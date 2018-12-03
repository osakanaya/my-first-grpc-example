package uk.me.uohiro.grpc.example.test;

import java.io.IOException;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServerRule extends TestWatcher {
	private final Server server;
	
	public GrpcServerRule(int port, BindableService... bindableServices) {
		ServerBuilder serverBuilder = ServerBuilder.forPort(port);
		
		for (BindableService bindableService : bindableServices) {
			serverBuilder.addService(bindableService);
		}
		
		this.server = serverBuilder.build();
	}
	
	@Override
	protected void starting(Description description) {
		System.out.println("Start the server");
		
		try {
			server.start();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	protected void finished(Description description) {
		System.out.println("Stop the server");
		
		if (server != null) {
			server.shutdown();
		}
	}
}
