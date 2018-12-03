package uk.me.uohiro.grpc.example.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.grpc.example.model.Feature;
import uk.me.uohiro.grpc.example.model.Point;
import uk.me.uohiro.grpc.example.model.Rectangle;
import uk.me.uohiro.grpc.example.model.RouteGuideGrpc.RouteGuideImplBase;
import uk.me.uohiro.grpc.example.model.RouteNote;
import uk.me.uohiro.grpc.example.model.RouteSummary;
import uk.me.uohiro.grpc.example.util.RouteGuideUtil;

public class RouteGuideServer {
	private static final Logger logger = Logger.getLogger(RouteGuideServer.class.getName());
	
	private final int port;
	private final Server server;
	
	public RouteGuideServer(int port) throws IOException {
		this(port, RouteGuideUtil.getDefaultFeaturesFile());
	}
	
	public RouteGuideServer(int port, URL featureFile) throws IOException {
		this(ServerBuilder.forPort(port), port, RouteGuideUtil.parseFeatures(featureFile));
	}
	
	public RouteGuideServer(ServerBuilder<?> serverBuilder, int port, Collection<Feature> features) {
		this.port = port;
		this.server = serverBuilder.addService(new RouteGuideService(features)).build();
	}
	
	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				RouteGuideServer.this.stop();
				System.err.println("*** Server shut down.");
			}
		});
	}
	
	public void stop() {
		if (server != null) {
			server.shutdown();
		}
	}
	
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}
	
	public static void main(String[] args) throws Exception {
		RouteGuideServer server = new RouteGuideServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
	
	private static class RouteGuideService extends RouteGuideImplBase {
		private final Collection<Feature> features;
		private final ConcurrentMap<Point, List<RouteNote>> routeNotes = new ConcurrentHashMap<>();
		
		RouteGuideService(Collection<Feature> features) {
			this.features = features;
		}
		
		@Override
		public void getFeature(Point request, StreamObserver<Feature> responseObserver) {
			responseObserver.onNext(checkFeature(request));
			responseObserver.onCompleted();
		}

		@Override
		public void listFeatures(Rectangle request, StreamObserver<Feature> responseObserver) {
			int left = Math.min(request.getLo().getLongitude(), request.getHi().getLongitude());
			int right = Math.max(request.getLo().getLongitude(), request.getHi().getLongitude());
			int top = Math.max(request.getLo().getLatitude(), request.getHi().getLatitude());
			int bottom = Math.min(request.getLo().getLatitude(), request.getHi().getLatitude());
			
			for (Feature feature : features) {
				if (!RouteGuideUtil.exists(feature)) {
					continue;
				}
				
				int lat = feature.getLocation().getLatitude();
				int lon = feature.getLocation().getLongitude();
				if (lon >= left && lon <= right && lat >= bottom && lat <= top) {
					responseObserver.onNext(feature);
				}
			}
			
			responseObserver.onCompleted();
		}

		@Override
		public StreamObserver<Point> recordRoute(StreamObserver<RouteSummary> responseObserver) {
			return new StreamObserver<Point>() {
				int pointCount;
				int featureCount;
				int distance;
				Point previous;
				final long startTime = System.nanoTime();

				@Override
				public void onCompleted() {
					long seconds = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime);
					
					responseObserver.onNext(
							RouteSummary.newBuilder()
								.setPointCount(pointCount)
								.setFeatureCount(featureCount)
								.setDistance(distance)
								.setElapsedTime((int)seconds).build());

					responseObserver.onCompleted();
				}
				
				@Override
				public void onError(Throwable t) {
					logger.log(Level.WARNING, "recordRoute cancelled");
					
				}
				@Override
				public void onNext(Point point) {
					pointCount++;
					if (RouteGuideUtil.exists(checkFeature(point))) {
						featureCount++;
					}
					
					if (previous != null) {
						distance += calcDistance(previous, point);
					}
					
					previous = point;
				}
			};
		}

		@Override
		public StreamObserver<RouteNote> routeChat(StreamObserver<RouteNote> responseObserver) {
			return new StreamObserver<RouteNote>() {

				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable t) {
					logger.log(Level.WARNING, "routeChat cancelled");
				}

				@Override
				public void onNext(RouteNote note) {
					logger.log(Level.INFO, "[Server]Got message \"" + note.getMessage() + 
							"\" at " + note.getLocation().getLatitude() + ", " + note.getLocation().getLongitude());

					List<RouteNote> notes = getOrCreateNotes(note.getLocation());
					
					for (RouteNote prevNote : notes.toArray(new RouteNote[0])) {
						logger.log(Level.INFO, "[Server]Sending message \"" + prevNote.getMessage() + 
								"\" at " + prevNote.getLocation().getLatitude() + ", " + prevNote.getLocation().getLongitude());

						responseObserver.onNext(prevNote);
					}
					
					notes.add(note);
				}
			};
		}
		
		private List<RouteNote> getOrCreateNotes(Point location) {
			List<RouteNote> notes = Collections.synchronizedList(new ArrayList<RouteNote>());
			List<RouteNote> prevNotes = routeNotes.putIfAbsent(location, notes);
			
			return prevNotes != null ? prevNotes : notes;
			
		}

		private Feature checkFeature(Point location) {
			for (Feature feature : features) {
				if (feature.getLocation().getLatitude() == location.getLatitude()
						&& feature.getLocation().getLongitude() == location.getLongitude()) {
					return feature;
				}
			}
			
			return Feature.newBuilder().setName("").setLocation(location).build();
		}
		
		private static int calcDistance(Point start, Point end) {
			int r = 6371000;
			
			double lat1 = Math.toRadians(RouteGuideUtil.getLatitude(start));
			double lat2 = Math.toRadians(RouteGuideUtil.getLatitude(end));
			double lon1 = Math.toRadians(RouteGuideUtil.getLongitude(start));
			double lon2 = Math.toRadians(RouteGuideUtil.getLongitude(end));
			
			double deltaLat = lat2 - lat1;
			double deltaLon = lon2 - lon1;
			
			double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
					+ Math.cos(lat1) * Math.cos(lat2) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			
			return (int)(r * c);
		}
	}
}
