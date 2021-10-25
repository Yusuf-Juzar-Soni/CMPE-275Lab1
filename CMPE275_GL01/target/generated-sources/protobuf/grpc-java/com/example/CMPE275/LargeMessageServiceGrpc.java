package com.example.CMPE275;

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
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: GreetingService.proto")
public final class LargeMessageServiceGrpc {

  private LargeMessageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.CMPE275.LargeMessageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.CMPE275.GreetingServiceOuterClass.HelloRequest,
      com.example.CMPE275.GreetingServiceOuterClass.Responses> getLargeMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "largeMessage",
      requestType = com.example.CMPE275.GreetingServiceOuterClass.HelloRequest.class,
      responseType = com.example.CMPE275.GreetingServiceOuterClass.Responses.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.CMPE275.GreetingServiceOuterClass.HelloRequest,
      com.example.CMPE275.GreetingServiceOuterClass.Responses> getLargeMessageMethod() {
    io.grpc.MethodDescriptor<com.example.CMPE275.GreetingServiceOuterClass.HelloRequest, com.example.CMPE275.GreetingServiceOuterClass.Responses> getLargeMessageMethod;
    if ((getLargeMessageMethod = LargeMessageServiceGrpc.getLargeMessageMethod) == null) {
      synchronized (LargeMessageServiceGrpc.class) {
        if ((getLargeMessageMethod = LargeMessageServiceGrpc.getLargeMessageMethod) == null) {
          LargeMessageServiceGrpc.getLargeMessageMethod = getLargeMessageMethod =
              io.grpc.MethodDescriptor.<com.example.CMPE275.GreetingServiceOuterClass.HelloRequest, com.example.CMPE275.GreetingServiceOuterClass.Responses>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "largeMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.CMPE275.GreetingServiceOuterClass.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.CMPE275.GreetingServiceOuterClass.Responses.getDefaultInstance()))
              .setSchemaDescriptor(new LargeMessageServiceMethodDescriptorSupplier("largeMessage"))
              .build();
        }
      }
    }
    return getLargeMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LargeMessageServiceStub newStub(io.grpc.Channel channel) {
    return new LargeMessageServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LargeMessageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LargeMessageServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LargeMessageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LargeMessageServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class LargeMessageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void largeMessage(com.example.CMPE275.GreetingServiceOuterClass.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.CMPE275.GreetingServiceOuterClass.Responses> responseObserver) {
      asyncUnimplementedUnaryCall(getLargeMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLargeMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.CMPE275.GreetingServiceOuterClass.HelloRequest,
                com.example.CMPE275.GreetingServiceOuterClass.Responses>(
                  this, METHODID_LARGE_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class LargeMessageServiceStub extends io.grpc.stub.AbstractStub<LargeMessageServiceStub> {
    private LargeMessageServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LargeMessageServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LargeMessageServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LargeMessageServiceStub(channel, callOptions);
    }

    /**
     */
    public void largeMessage(com.example.CMPE275.GreetingServiceOuterClass.HelloRequest request,
        io.grpc.stub.StreamObserver<com.example.CMPE275.GreetingServiceOuterClass.Responses> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLargeMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class LargeMessageServiceBlockingStub extends io.grpc.stub.AbstractStub<LargeMessageServiceBlockingStub> {
    private LargeMessageServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LargeMessageServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LargeMessageServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LargeMessageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.CMPE275.GreetingServiceOuterClass.Responses largeMessage(com.example.CMPE275.GreetingServiceOuterClass.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getLargeMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class LargeMessageServiceFutureStub extends io.grpc.stub.AbstractStub<LargeMessageServiceFutureStub> {
    private LargeMessageServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LargeMessageServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LargeMessageServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LargeMessageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.CMPE275.GreetingServiceOuterClass.Responses> largeMessage(
        com.example.CMPE275.GreetingServiceOuterClass.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLargeMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LARGE_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LargeMessageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LargeMessageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LARGE_MESSAGE:
          serviceImpl.largeMessage((com.example.CMPE275.GreetingServiceOuterClass.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.example.CMPE275.GreetingServiceOuterClass.Responses>) responseObserver);
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

  private static abstract class LargeMessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LargeMessageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.CMPE275.GreetingServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LargeMessageService");
    }
  }

  private static final class LargeMessageServiceFileDescriptorSupplier
      extends LargeMessageServiceBaseDescriptorSupplier {
    LargeMessageServiceFileDescriptorSupplier() {}
  }

  private static final class LargeMessageServiceMethodDescriptorSupplier
      extends LargeMessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LargeMessageServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LargeMessageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LargeMessageServiceFileDescriptorSupplier())
              .addMethod(getLargeMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
