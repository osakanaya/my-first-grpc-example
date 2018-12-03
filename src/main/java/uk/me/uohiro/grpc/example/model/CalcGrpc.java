package uk.me.uohiro.grpc.example.model;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: calc.proto")
public final class CalcGrpc {

  private CalcGrpc() {}

  public static final String SERVICE_NAME = "calc.Calc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.AddRequest,
      uk.me.uohiro.grpc.example.model.IntResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Add",
      requestType = uk.me.uohiro.grpc.example.model.AddRequest.class,
      responseType = uk.me.uohiro.grpc.example.model.IntResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.AddRequest,
      uk.me.uohiro.grpc.example.model.IntResponse> getAddMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.AddRequest, uk.me.uohiro.grpc.example.model.IntResponse> getAddMethod;
    if ((getAddMethod = CalcGrpc.getAddMethod) == null) {
      synchronized (CalcGrpc.class) {
        if ((getAddMethod = CalcGrpc.getAddMethod) == null) {
          CalcGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.grpc.example.model.AddRequest, uk.me.uohiro.grpc.example.model.IntResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "calc.Calc", "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.AddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.IntResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalcMethodDescriptorSupplier("Add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.SumRequest,
      uk.me.uohiro.grpc.example.model.IntResponse> getSumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sum",
      requestType = uk.me.uohiro.grpc.example.model.SumRequest.class,
      responseType = uk.me.uohiro.grpc.example.model.IntResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.SumRequest,
      uk.me.uohiro.grpc.example.model.IntResponse> getSumMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.SumRequest, uk.me.uohiro.grpc.example.model.IntResponse> getSumMethod;
    if ((getSumMethod = CalcGrpc.getSumMethod) == null) {
      synchronized (CalcGrpc.class) {
        if ((getSumMethod = CalcGrpc.getSumMethod) == null) {
          CalcGrpc.getSumMethod = getSumMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.grpc.example.model.SumRequest, uk.me.uohiro.grpc.example.model.IntResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "calc.Calc", "Sum"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.SumRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.IntResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalcMethodDescriptorSupplier("Sum"))
                  .build();
          }
        }
     }
     return getSumMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalcStub newStub(io.grpc.Channel channel) {
    return new CalcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalcFutureStub(channel);
  }

  /**
   */
  public static abstract class CalcImplBase implements io.grpc.BindableService {

    /**
     */
    public void add(uk.me.uohiro.grpc.example.model.AddRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.IntResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    public void sum(uk.me.uohiro.grpc.example.model.SumRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.IntResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSumMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.grpc.example.model.AddRequest,
                uk.me.uohiro.grpc.example.model.IntResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getSumMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.grpc.example.model.SumRequest,
                uk.me.uohiro.grpc.example.model.IntResponse>(
                  this, METHODID_SUM)))
          .build();
    }
  }

  /**
   */
  public static final class CalcStub extends io.grpc.stub.AbstractStub<CalcStub> {
    private CalcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalcStub(channel, callOptions);
    }

    /**
     */
    public void add(uk.me.uohiro.grpc.example.model.AddRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.IntResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sum(uk.me.uohiro.grpc.example.model.SumRequest request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.IntResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CalcBlockingStub extends io.grpc.stub.AbstractStub<CalcBlockingStub> {
    private CalcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalcBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.grpc.example.model.IntResponse add(uk.me.uohiro.grpc.example.model.AddRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public uk.me.uohiro.grpc.example.model.IntResponse sum(uk.me.uohiro.grpc.example.model.SumRequest request) {
      return blockingUnaryCall(
          getChannel(), getSumMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalcFutureStub extends io.grpc.stub.AbstractStub<CalcFutureStub> {
    private CalcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.grpc.example.model.IntResponse> add(
        uk.me.uohiro.grpc.example.model.AddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.grpc.example.model.IntResponse> sum(
        uk.me.uohiro.grpc.example.model.SumRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_SUM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((uk.me.uohiro.grpc.example.model.AddRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.IntResponse>) responseObserver);
          break;
        case METHODID_SUM:
          serviceImpl.sum((uk.me.uohiro.grpc.example.model.SumRequest) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.IntResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.grpc.example.model.CalcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calc");
    }
  }

  private static final class CalcFileDescriptorSupplier
      extends CalcBaseDescriptorSupplier {
    CalcFileDescriptorSupplier() {}
  }

  private static final class CalcMethodDescriptorSupplier
      extends CalcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalcMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalcFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getSumMethod())
              .build();
        }
      }
    }
    return result;
  }
}
