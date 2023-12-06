package com.example.exercise1.ChatGRPC;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import com.example.exercise1.grpc.*;

public class ChatService extends ChatServiceGrpc.ChatServiceImplBase   {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(3000)
                .addService(new ChatServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }

    @Override
    public StreamObserver<Chat.ChatMessage> streamChat(StreamObserver<Chat.ChatMessage> responseObserver) {
        return null;
    }

    static class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {
        @Override
        public void joinChat(Chat.ChatMessage request, StreamObserver<Chat.ChatMessage> responseObserver) {
            // Xử lý logic khi một client tham gia chat
            System.out.println("haha");
            responseObserver.onNext(Chat.ChatMessage.newBuilder().setContent("User " + request.getSender() + " joined the chat!").build());
            responseObserver.onCompleted();
        }

        @Override
        public void sendMessage(Chat.ChatMessage request, StreamObserver<Chat.ChatMessage> responseObserver) {
            // Xử lý logic khi một client gửi tin nhắn
            responseObserver.onNext(Chat.ChatMessage.newBuilder().setContent("User " + request.getSender() + " says: " + request.getContent()).build());
            responseObserver.onCompleted();
        }

        @Override
        public void leaveChat(Chat.ChatMessage request, StreamObserver<Chat.ChatMessage> responseObserver) {
            // Xử lý logic khi một client rời khỏi chat
            responseObserver.onNext(Chat.ChatMessage.newBuilder().setContent("User " + request.getSender() + " left the chat!").build());
            responseObserver.onCompleted();
        }

        @Override
        public StreamObserver<Chat.ChatMessage> streamChat(StreamObserver<Chat.ChatMessage> responseObserver) {
            // Xử lý logic để mở một luồng streaming chat
            return new StreamObserver<Chat.ChatMessage>() {
                @Override
                public void onNext(Chat.ChatMessage message) {
                    // Xử lý logic khi nhận được tin nhắn từ client
                    responseObserver.onNext(Chat.ChatMessage.newBuilder().setContent("User " + message.getSender() + " says: " + message.getContent()).build());
                }

                @Override
                public void onError(Throwable t) {
                    // Xử lý logic khi có lỗi
                    System.err.println("Error in chat stream: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // Xử lý logic khi client kết thúc luồng streaming chat
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
