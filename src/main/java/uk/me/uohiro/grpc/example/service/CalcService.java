package uk.me.uohiro.grpc.example.service;

import java.util.List;

import io.grpc.stub.StreamObserver;
import uk.me.uohiro.grpc.example.model.AddRequest;
import uk.me.uohiro.grpc.example.model.CalcGrpc.CalcImplBase;
import uk.me.uohiro.grpc.example.model.IntResponse;
import uk.me.uohiro.grpc.example.model.SumRequest;

public class CalcService extends CalcImplBase {

	@Override
	public void add(AddRequest request, StreamObserver<IntResponse> responseObserver) {
		System.out.println("calc add");
		
		IntResponse response = IntResponse
				.newBuilder()
				.setValue(request.getX() + request.getY())
				.build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void sum(SumRequest request, StreamObserver<IntResponse> responseObserver) {
		System.out.println("calc add");
		
		IntResponse response = IntResponse
				.newBuilder()
				.setValue(sum(request.getValuesList()))
				.build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	private int sum(List<Integer> values) {
		return values.stream().mapToInt(value -> value).sum();
	}
}
