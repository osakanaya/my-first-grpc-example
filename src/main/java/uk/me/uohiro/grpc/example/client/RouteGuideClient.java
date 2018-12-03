package uk.me.uohiro.grpc.example.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.Message;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.grpc.example.model.Feature;
import uk.me.uohiro.grpc.example.model.Point;
import uk.me.uohiro.grpc.example.model.Rectangle;
import uk.me.uohiro.grpc.example.model.RouteGuideGrpc;
import uk.me.uohiro.grpc.example.model.RouteGuideGrpc.RouteGuideBlockingStub;
import uk.me.uohiro.grpc.example.model.RouteGuideGrpc.RouteGuideStub;
import uk.me.uohiro.grpc.example.model.RouteNote;
import uk.me.uohiro.grpc.example.model.RouteSummary;
import uk.me.uohiro.grpc.example.util.RouteGuideUtil;

public class RouteGuideClient {
	private static final Logger logger = Logger.getLogger(RouteGuideClient.class.getName());

	private final ManagedChannel channel;
	private final RouteGuideBlockingStub blockingStub;
	private final RouteGuideStub asyncStub;

	private Random random = new Random();
	private TestHelper testHelper;

	public RouteGuideClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public RouteGuideClient(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = RouteGuideGrpc.newBlockingStub(channel);
		asyncStub = RouteGuideGrpc.newStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getFeature(int lat, int lon) {
		info("*** GetFeature: lat={0} lon={1}", lat, lon);
		
		Point request = Point.newBuilder().setLatitude(lat).setLongitude(lon).build();
		
		Feature feature;
		try {
			feature = blockingStub.getFeature(request);
			if (testHelper != null) {
				testHelper.onMessage(feature);
			}
		} catch (StatusRuntimeException e) {
			warning("RPC failed: {0}", e.getStatus());
			
			if (testHelper != null) {
				testHelper.onRpcError(e);
			}
			
			return;
		}
		
		if (RouteGuideUtil.exists(feature)) {
			info("Found feature called \"{0}\" at {1}, {2}",
					feature.getName(),
					RouteGuideUtil.getLatitude(feature.getLocation()),
					RouteGuideUtil.getLongitude(feature.getLocation()));
		} else {
			info("Found no feature at {0}, {1}",
					RouteGuideUtil.getLatitude(feature.getLocation()),
					RouteGuideUtil.getLongitude(feature.getLocation()));
		}
	}
	
	public void listFeatures(int lowLat, int lowLon, int hiLat, int hiLon) {
		info("*** ListFeatures: lowLat={0} lowLon={1} hiLat={2} hiLon={3}", lowLat, lowLon, hiLat, hiLon);
		
		Rectangle request = Rectangle.newBuilder()
				.setLo(Point.newBuilder().setLatitude(lowLat).setLongitude(lowLon).build())
				.setHi(Point.newBuilder().setLatitude(hiLat).setLongitude(hiLon).build()).build();
		
		Iterator<Feature> features;
		
		try {
			features = blockingStub.listFeatures(request);
			
			for(int i = 1; features.hasNext(); i++) {
				Feature feature = features.next();
				info("Resutl #" + i + ": {0}", feature);
				if (testHelper != null) {
					testHelper.onMessage(feature);
				}
			}
		} catch (StatusRuntimeException e) {
			warning("RPC failed: {0}", e.getStatus());
			if (testHelper != null) {
				testHelper.onRpcError(e);
			}
		}
	}
	
	public void recordRoute(List<Feature> features, int numPoints) throws InterruptedException {
		info("*** RecordRoute");
		final CountDownLatch finishLatch = new CountDownLatch(1);
		
		StreamObserver<RouteSummary> responseObserver = new StreamObserver<RouteSummary>() {

			@Override
			public void onCompleted() {
				info("Finished RecordRoute");
				finishLatch.countDown();
			}

			@Override
			public void onError(Throwable t) {
				warning("RecordRoute Failed: {0}", Status.fromThrowable(t));
				if (testHelper != null) {
					testHelper.onRpcError(t);
				}
				finishLatch.countDown();
			}

			@Override
			public void onNext(RouteSummary summary) {
				info("Finished trip with {0} points. Passed {1} features. " + "Travelled {2} meters. It took {3} seconds.",
						summary.getPointCount(), summary.getFeatureCount(), summary.getDistance(), summary.getElapsedTime());
				if (testHelper != null) {
					testHelper.onMessage(summary);
				}
			}
			
		};
		
		StreamObserver<Point> requestObserver = asyncStub.recordRoute(responseObserver);
		
		try {
			for(int i = 0; i < numPoints; ++i) {
				int index = random.nextInt(features.size());
				Point point = features.get(index).getLocation();
				info("Visiting point {0}, {1}", RouteGuideUtil.getLatitude(point), RouteGuideUtil.getLongitude(point));
				requestObserver.onNext(point);
				
				Thread.sleep(random.nextInt(1000) + 500);
				if (finishLatch.getCount() == 0) {
					return;
				}
			}
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		}
		
		requestObserver.onCompleted();
	}

	public CountDownLatch routeChat() throws Exception {
		info("*** RouteChat");
		final CountDownLatch finishLatch = new CountDownLatch(1);
		
		StreamObserver<RouteNote> requestObserver = asyncStub.routeChat(new StreamObserver<RouteNote>() {

			@Override
			public void onCompleted() {
				info("Finished RouteChat");
				finishLatch.countDown();
			}

			@Override
			public void onError(Throwable t) {
				warning("RouteChat Failed: {0}", Status.fromThrowable(t));
				if(testHelper != null) {
					testHelper.onRpcError(t);
				}
				finishLatch.countDown();
			}

			@Override
			public void onNext(RouteNote note) {
				info("[Client]Got message \"{0}\" at {1}, {2}", note.getMessage(), note.getLocation().getLatitude(), note.getLocation().getLongitude());
				if (testHelper != null) {
					testHelper.onMessage(note);
				}
			}
		});
		
		try {
			RouteNote[] requests = {
				newNote("Message 1", 0, 0),
				newNote("Message 2", 0, 1),
				newNote("Message 3", 1, 0),
				newNote("Message 4", 1, 1),
				newNote("Message 5", 0, 0),
				newNote("Message 6", 0, 1),
				newNote("Message 7", 1, 0),
				newNote("Message 8", 1, 1),
				newNote("Message 9", 0, 0),
				newNote("Message 10", 0, 1),
				newNote("Message 11", 1, 0),
				newNote("Message 12", 1, 1)
			};
			
			for (RouteNote request : requests) {
				info("[Client]Sending message \"{0}\" at {1}, {2}", 
						request.getMessage(), request.getLocation().getLatitude(), request.getLocation().getLongitude());
				requestObserver.onNext(request);
			}
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		}
		
		Thread.sleep(1000);
		
		requestObserver.onCompleted();
		
		return finishLatch;
	}
	
	public static void main(String[] args) throws Exception {
		List<Feature> features;

		try {
			features = RouteGuideUtil.parseFeatures(RouteGuideUtil.getDefaultFeaturesFile());
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		RouteGuideClient client = new RouteGuideClient("localhost", 8080);

		try {
			// Looking for a valid feature
			client.getFeature(409146138, -746188906);

			// Feature missing.
			client.getFeature(0, 0);

			// Looking for features between 40, -75 and 42, -73.
			client.listFeatures(400000000, -750000000, 420000000, -730000000);

			// Record a few randomly selected points from the features file.
			client.recordRoute(features, 10);

			// Send and receive some notes.
			CountDownLatch finishLatch = client.routeChat();

			if (!finishLatch.await(1, TimeUnit.MINUTES)) {
				client.warning("routeChat can not finish within 1 minutes");
			}
		} finally {
			client.shutdown();
		}
	}

	private void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}
	
	private void warning(String msg, Object... params) {
		logger.log(Level.WARNING, msg, params);
	}
	
	private RouteNote newNote(String message, int lat, int lon) {
		return RouteNote.newBuilder().setMessage(message)
				.setLocation(Point.newBuilder().setLatitude(lat).setLongitude(lon).build()).build();
	}
	 
	@VisibleForTesting
	void setRandom(Random random) {
		this.random = random;
	}

	@VisibleForTesting
	interface TestHelper {
		void onMessage(Message message);

		void onRpcError(Throwable exception);
	}

	@VisibleForTesting
	void setTestHelper(TestHelper testHelper) {
		this.testHelper = testHelper;
	}
}
