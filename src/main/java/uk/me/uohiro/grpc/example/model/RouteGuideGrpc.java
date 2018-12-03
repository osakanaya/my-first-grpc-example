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
    comments = "Source: route_guide.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "routeguide.RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Point,
      uk.me.uohiro.grpc.example.model.Feature> getGetFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeature",
      requestType = uk.me.uohiro.grpc.example.model.Point.class,
      responseType = uk.me.uohiro.grpc.example.model.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Point,
      uk.me.uohiro.grpc.example.model.Feature> getGetFeatureMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Point, uk.me.uohiro.grpc.example.model.Feature> getGetFeatureMethod;
    if ((getGetFeatureMethod = RouteGuideGrpc.getGetFeatureMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getGetFeatureMethod = RouteGuideGrpc.getGetFeatureMethod) == null) {
          RouteGuideGrpc.getGetFeatureMethod = getGetFeatureMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.grpc.example.model.Point, uk.me.uohiro.grpc.example.model.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "GetFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.Feature.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("GetFeature"))
                  .build();
          }
        }
     }
     return getGetFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Rectangle,
      uk.me.uohiro.grpc.example.model.Feature> getListFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatures",
      requestType = uk.me.uohiro.grpc.example.model.Rectangle.class,
      responseType = uk.me.uohiro.grpc.example.model.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Rectangle,
      uk.me.uohiro.grpc.example.model.Feature> getListFeaturesMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Rectangle, uk.me.uohiro.grpc.example.model.Feature> getListFeaturesMethod;
    if ((getListFeaturesMethod = RouteGuideGrpc.getListFeaturesMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getListFeaturesMethod = RouteGuideGrpc.getListFeaturesMethod) == null) {
          RouteGuideGrpc.getListFeaturesMethod = getListFeaturesMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.grpc.example.model.Rectangle, uk.me.uohiro.grpc.example.model.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "ListFeatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.Rectangle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.Feature.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("ListFeatures"))
                  .build();
          }
        }
     }
     return getListFeaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Point,
      uk.me.uohiro.grpc.example.model.RouteSummary> getRecordRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecordRoute",
      requestType = uk.me.uohiro.grpc.example.model.Point.class,
      responseType = uk.me.uohiro.grpc.example.model.RouteSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Point,
      uk.me.uohiro.grpc.example.model.RouteSummary> getRecordRouteMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.Point, uk.me.uohiro.grpc.example.model.RouteSummary> getRecordRouteMethod;
    if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
          RouteGuideGrpc.getRecordRouteMethod = getRecordRouteMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.grpc.example.model.Point, uk.me.uohiro.grpc.example.model.RouteSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "RecordRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.RouteSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("RecordRoute"))
                  .build();
          }
        }
     }
     return getRecordRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.RouteNote,
      uk.me.uohiro.grpc.example.model.RouteNote> getRouteChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RouteChat",
      requestType = uk.me.uohiro.grpc.example.model.RouteNote.class,
      responseType = uk.me.uohiro.grpc.example.model.RouteNote.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.RouteNote,
      uk.me.uohiro.grpc.example.model.RouteNote> getRouteChatMethod() {
    io.grpc.MethodDescriptor<uk.me.uohiro.grpc.example.model.RouteNote, uk.me.uohiro.grpc.example.model.RouteNote> getRouteChatMethod;
    if ((getRouteChatMethod = RouteGuideGrpc.getRouteChatMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getRouteChatMethod = RouteGuideGrpc.getRouteChatMethod) == null) {
          RouteGuideGrpc.getRouteChatMethod = getRouteChatMethod = 
              io.grpc.MethodDescriptor.<uk.me.uohiro.grpc.example.model.RouteNote, uk.me.uohiro.grpc.example.model.RouteNote>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "RouteChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.RouteNote.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  uk.me.uohiro.grpc.example.model.RouteNote.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("RouteChat"))
                  .build();
          }
        }
     }
     return getRouteChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    return new RouteGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RouteGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RouteGuideFutureStub(channel);
  }

  /**
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFeature(uk.me.uohiro.grpc.example.model.Point request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFeatureMethod(), responseObserver);
    }

    /**
     */
    public void listFeatures(uk.me.uohiro.grpc.example.model.Rectangle request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(getListFeaturesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Point> recordRoute(
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecordRouteMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteNote> responseObserver) {
      return asyncUnimplementedStreamingCall(getRouteChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFeatureMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                uk.me.uohiro.grpc.example.model.Point,
                uk.me.uohiro.grpc.example.model.Feature>(
                  this, METHODID_GET_FEATURE)))
          .addMethod(
            getListFeaturesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.grpc.example.model.Rectangle,
                uk.me.uohiro.grpc.example.model.Feature>(
                  this, METHODID_LIST_FEATURES)))
          .addMethod(
            getRecordRouteMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.grpc.example.model.Point,
                uk.me.uohiro.grpc.example.model.RouteSummary>(
                  this, METHODID_RECORD_ROUTE)))
          .addMethod(
            getRouteChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                uk.me.uohiro.grpc.example.model.RouteNote,
                uk.me.uohiro.grpc.example.model.RouteNote>(
                  this, METHODID_ROUTE_CHAT)))
          .build();
    }
  }

  /**
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractStub<RouteGuideStub> {
    private RouteGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     */
    public void getFeature(uk.me.uohiro.grpc.example.model.Point request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Feature> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listFeatures(uk.me.uohiro.grpc.example.model.Rectangle request,
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Feature> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Point> recordRoute(
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRecordRouteMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteNote> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRouteChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }

    /**
     */
    public uk.me.uohiro.grpc.example.model.Feature getFeature(uk.me.uohiro.grpc.example.model.Point request) {
      return blockingUnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<uk.me.uohiro.grpc.example.model.Feature> listFeatures(
        uk.me.uohiro.grpc.example.model.Rectangle request) {
      return blockingServerStreamingCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<uk.me.uohiro.grpc.example.model.Feature> getFeature(
        uk.me.uohiro.grpc.example.model.Point request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FEATURE = 0;
  private static final int METHODID_LIST_FEATURES = 1;
  private static final int METHODID_RECORD_ROUTE = 2;
  private static final int METHODID_ROUTE_CHAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature((uk.me.uohiro.grpc.example.model.Point) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Feature>) responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures((uk.me.uohiro.grpc.example.model.Rectangle) request,
              (io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.Feature>) responseObserver);
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
        case METHODID_RECORD_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordRoute(
              (io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteSummary>) responseObserver);
        case METHODID_ROUTE_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.routeChat(
              (io.grpc.stub.StreamObserver<uk.me.uohiro.grpc.example.model.RouteNote>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RouteGuideBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return uk.me.uohiro.grpc.example.model.RouteGuideProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RouteGuide");
    }
  }

  private static final class RouteGuideFileDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier {
    RouteGuideFileDescriptorSupplier() {}
  }

  private static final class RouteGuideMethodDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RouteGuideMethodDescriptorSupplier(String methodName) {
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
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideFileDescriptorSupplier())
              .addMethod(getGetFeatureMethod())
              .addMethod(getListFeaturesMethod())
              .addMethod(getRecordRouteMethod())
              .addMethod(getRouteChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
