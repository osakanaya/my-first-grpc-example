package uk.me.uohiro.grpc.example.client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import uk.me.uohiro.grpc.example.model.AddRequest;
import uk.me.uohiro.grpc.example.model.CalcGrpc;
import uk.me.uohiro.grpc.example.model.CalcGrpc.CalcBlockingStub;
import uk.me.uohiro.grpc.example.model.IntResponse;
import uk.me.uohiro.grpc.example.model.SumRequest;

public class CalcClient {
	private final CalcBlockingStub stub;
	
	public CalcClient(ManagedChannel managedChannel) {
		this.stub = CalcGrpc.newBlockingStub(managedChannel);
	}
	
	public int add(int x, int y) {
		AddRequest request = AddRequest
				.newBuilder()
				.setX(x)
				.setY(y)
				.build();
		
		IntResponse response = stub.add(request);
		
		return response.getValue();
	}
	
	public int sum(int... values) {
		SumRequest request = SumRequest
				.newBuilder()
				.addAllValues(toList(values))
				.build();
		
		IntResponse response = stub.sum(request);
		
		return response.getValue();
	}
	
	private List<Integer> toList(int... values) {
		return Arrays.stream(values).mapToObj(value -> value).collect(Collectors.toList());
	}
}
