package uk.me.uohiro.grpc.example.test;

import java.util.concurrent.TimeUnit;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ManagedChannelRule extends TestWatcher {
	private final String host;
	private final int port;
	private ManagedChannel managedChannel;
	
	public ManagedChannelRule(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public ManagedChannel getManagedChannel() {
		return managedChannel;
	}

	@Override
	protected void starting(Description description) {
		System.out.println("Connect to the server");
		
		this.managedChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
	}

	@Override
	protected void finished(Description description) {
		System.out.println("Disconnect from the server");
		
		if (managedChannel != null) {
			managedChannel.shutdownNow();
			
			try {
				managedChannel.awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
	}
}
