package com.example.exercise1.grpc;

import io.grpc.stub.StreamObserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: Chat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.example.exercise1.grpc.ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getJoinChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinChat",
      requestType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      responseType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getJoinChatMethod() {
    io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage> getJoinChatMethod;
    if ((getJoinChatMethod = ChatServiceGrpc.getJoinChatMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getJoinChatMethod = ChatServiceGrpc.getJoinChatMethod) == null) {
          ChatServiceGrpc.getJoinChatMethod = getJoinChatMethod =
              io.grpc.MethodDescriptor.<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("JoinChat"))
              .build();
        }
      }
    }
    return getJoinChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      responseType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage> getSendMessageMethod;
    if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
          ChatServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("SendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getLeaveChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LeaveChat",
      requestType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      responseType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getLeaveChatMethod() {
    io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage> getLeaveChatMethod;
    if ((getLeaveChatMethod = ChatServiceGrpc.getLeaveChatMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getLeaveChatMethod = ChatServiceGrpc.getLeaveChatMethod) == null) {
          ChatServiceGrpc.getLeaveChatMethod = getLeaveChatMethod =
              io.grpc.MethodDescriptor.<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LeaveChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("LeaveChat"))
              .build();
        }
      }
    }
    return getLeaveChatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getStreamChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamChat",
      requestType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      responseType = com.example.exercise1.grpc.Chat.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage,
      com.example.exercise1.grpc.Chat.ChatMessage> getStreamChatMethod() {
    io.grpc.MethodDescriptor<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage> getStreamChatMethod;
    if ((getStreamChatMethod = ChatServiceGrpc.getStreamChatMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getStreamChatMethod = ChatServiceGrpc.getStreamChatMethod) == null) {
          ChatServiceGrpc.getStreamChatMethod = getStreamChatMethod =
              io.grpc.MethodDescriptor.<com.example.exercise1.grpc.Chat.ChatMessage, com.example.exercise1.grpc.Chat.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.exercise1.grpc.Chat.ChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("StreamChat"))
              .build();
        }
      }
    }
    return getStreamChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub>() {
        @java.lang.Override
        public ChatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceStub(channel, callOptions);
        }
      };
    return ChatServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub>() {
        @java.lang.Override
        public ChatServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceBlockingStub(channel, callOptions);
        }
      };
    return ChatServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub>() {
        @java.lang.Override
        public ChatServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceFutureStub(channel, callOptions);
        }
      };
    return ChatServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void joinChat(com.example.exercise1.grpc.Chat.ChatMessage request,
        io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinChatMethod(), responseObserver);
    }

    /**
     */
    default void sendMessage(com.example.exercise1.grpc.Chat.ChatMessage request,
        io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    default void leaveChat(com.example.exercise1.grpc.Chat.ChatMessage request,
        io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLeaveChatMethod(), responseObserver);
    }

    /**
     */
    default void streamChat(com.example.exercise1.grpc.Chat.ChatMessage request,
        io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamChatMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ChatService.
   */
  public static abstract class ChatServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ChatServiceGrpc.bindService(this);
    }

    public abstract StreamObserver<Chat.ChatMessage> streamChat(StreamObserver<Chat.ChatMessage> responseObserver);
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ChatService.
   */
  public static final class ChatServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ChatServiceStub> {
    private ChatServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     */
    public void joinChat(com.example.exercise1.grpc.Chat.ChatMessage request,
        io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinChatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(com.example.exercise1.grpc.Chat.ChatMessage request,
        io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void leaveChat(com.example.exercise1.grpc.Chat.ChatMessage request,
        io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLeaveChatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * @return
     */
    public StreamObserver<Chat.ChatMessage> streamChat(StreamObserver<Chat.ChatMessage> responseObserver) {
      Chat.ChatMessage request = null;
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamChatMethod(), getCallOptions()), request, responseObserver);
      return responseObserver;
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ChatService.
   */
  public static final class ChatServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.exercise1.grpc.Chat.ChatMessage joinChat(com.example.exercise1.grpc.Chat.ChatMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinChatMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.exercise1.grpc.Chat.ChatMessage sendMessage(com.example.exercise1.grpc.Chat.ChatMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.exercise1.grpc.Chat.ChatMessage leaveChat(com.example.exercise1.grpc.Chat.ChatMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLeaveChatMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.exercise1.grpc.Chat.ChatMessage> streamChat(
        com.example.exercise1.grpc.Chat.ChatMessage request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamChatMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ChatService.
   */
  public static final class ChatServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.exercise1.grpc.Chat.ChatMessage> joinChat(
        com.example.exercise1.grpc.Chat.ChatMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinChatMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.exercise1.grpc.Chat.ChatMessage> sendMessage(
        com.example.exercise1.grpc.Chat.ChatMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.exercise1.grpc.Chat.ChatMessage> leaveChat(
        com.example.exercise1.grpc.Chat.ChatMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLeaveChatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_JOIN_CHAT = 0;
  private static final int METHODID_SEND_MESSAGE = 1;
  private static final int METHODID_LEAVE_CHAT = 2;
  private static final int METHODID_STREAM_CHAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_JOIN_CHAT:
          serviceImpl.joinChat((com.example.exercise1.grpc.Chat.ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.example.exercise1.grpc.Chat.ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage>) responseObserver);
          break;
        case METHODID_LEAVE_CHAT:
          serviceImpl.leaveChat((com.example.exercise1.grpc.Chat.ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage>) responseObserver);
          break;
        case METHODID_STREAM_CHAT:
          serviceImpl.streamChat((com.example.exercise1.grpc.Chat.ChatMessage) request,
              (io.grpc.stub.StreamObserver<com.example.exercise1.grpc.Chat.ChatMessage>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getJoinChatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.exercise1.grpc.Chat.ChatMessage,
              com.example.exercise1.grpc.Chat.ChatMessage>(
                service, METHODID_JOIN_CHAT)))
        .addMethod(
          getSendMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.exercise1.grpc.Chat.ChatMessage,
              com.example.exercise1.grpc.Chat.ChatMessage>(
                service, METHODID_SEND_MESSAGE)))
        .addMethod(
          getLeaveChatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.exercise1.grpc.Chat.ChatMessage,
              com.example.exercise1.grpc.Chat.ChatMessage>(
                service, METHODID_LEAVE_CHAT)))
        .addMethod(
          getStreamChatMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.exercise1.grpc.Chat.ChatMessage,
              com.example.exercise1.grpc.Chat.ChatMessage>(
                service, METHODID_STREAM_CHAT)))
        .build();
  }

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.exercise1.grpc.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ChatServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getJoinChatMethod())
              .addMethod(getSendMessageMethod())
              .addMethod(getLeaveChatMethod())
              .addMethod(getStreamChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
