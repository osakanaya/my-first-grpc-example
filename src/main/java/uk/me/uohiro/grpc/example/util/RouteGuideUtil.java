package uk.me.uohiro.grpc.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import com.google.protobuf.util.JsonFormat;

import uk.me.uohiro.grpc.example.model.Feature;
import uk.me.uohiro.grpc.example.model.FeatureDatabase;
import uk.me.uohiro.grpc.example.model.Point;
import uk.me.uohiro.grpc.example.service.RouteGuideServer;

public class RouteGuideUtil {
	private static final double COORD_FATOR = 1e7;
	
	public static double getLatitude(Point location) {
		return location.getLatitude() / COORD_FATOR;
	}
	
	public static double getLongitude(Point location) {
		return location.getLongitude() / COORD_FATOR;
	}
	
	public static URL getDefaultFeaturesFile() throws MalformedURLException {
//		return RouteGuideServer.class.getResource("route_guide_db.json");
		return RouteGuideServer.class.getClassLoader().getResource("route_guide_db.json");
	}
	
	public static List<Feature> parseFeatures(URL file) throws IOException {
		InputStream input = file.openStream();
		
		try {
			Reader reader = new InputStreamReader(input, Charset.forName("UTF-8"));
			
			try {
				FeatureDatabase.Builder database = FeatureDatabase.newBuilder();
				JsonFormat.parser().merge(reader, database);
				
				return database.getFeatureList();
			} finally {
				reader.close();
			}
		} finally {
			input.close();
		}
	}
	
	public static boolean exists(Feature feature) {
		return feature != null && !feature.getName().isEmpty();
	}
}
