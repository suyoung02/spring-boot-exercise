package com.example.exercise1.ChatGRPC;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.stub.StreamObserver;
import com.example.exercise1.grpc.*;

public class ChatClient extends ChatService.ChatServiceImpl  {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("Localhost", 3000)
                .usePlaintext()
                .build();
        ChatServiceGrpc.ChatServiceStub asyncStub = ChatServiceGrpc.newStub(channel);

        // Gửi yêu cầu tham gia chat
        asyncStub.joinChat(Chat.ChatMessage.newBuilder().setSender("Client1").build(), new StreamObserver<Chat.ChatMessage>() {
            @Override
            public void onNext(Chat.ChatMessage message) {
                // Xử lý logic khi nhận được tin nhắn từ server
                System.out.println("Received message: " + message.getContent());
            }

            @Override
            public void onError(Throwable t) {
                // Xử lý logic khi có lỗi
                System.err.println("Error in join chat: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Xử lý logic khi quá trình tham gia chat kết thúc
                System.out.println("Join chat completed.");
            }
        });

        // Gửi yêu cầu gửi tin nhắn
        asyncStub.sendMessage(Chat.ChatMessage.newBuilder().setSender("Client1").setContent("Hello").build(), new StreamObserver<Chat.ChatMessage>() {
            @Override
            public void onNext(Chat.ChatMessage message) {
                // Xử lý logic khi nhận được tin nhắn từ server
                System.out.println("Received message: " + message.getContent());
            }

            @Override
            public void onError(Throwable t) {
                // Xử lý logic khi có lỗi
                System.err.println("Error in send message: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Xử lý logic khi quá trình gửi tin nhắn kết thúc
                System.out.println("Send message completed.");
            }
        });

        // Gửi yêu cầu rời khỏi chat
        asyncStub.leaveChat(Chat.ChatMessage.newBuilder().setSender("Client1").build(), new StreamObserver<Chat.ChatMessage>() {
            @Override
            public void onNext(Chat.ChatMessage message) {
                // Xử lý logic khi nhận được tin nhắn từ server
                System.out.println("Received message: " + message.getContent());
            }

            @Override
            public void onError(Throwable t) {
                // Xử lý logic khi có lỗi
                System.err.println("Error in leave chat: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Xử lý logic khi quá trình rời khỏi chat kết thúc
                System.out.println("Leave chat completed.");
            }
        });

        // Mở luồng streaming chat
        StreamObserver<Chat.ChatMessage> streamChatRequestObserver = asyncStub.streamChat(new StreamObserver<Chat.ChatMessage>() {
            @Override
            public void onNext(Chat.ChatMessage message) {
                // Xử lý logic khi nhận được tin nhắn từ server
                System.out.println("Received message: " + message.getContent());
            }

            @Override
            public void onError(Throwable t) {
                // Xử lý logic khi có lỗi
                System.err.println("Error in stream chat: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Xử lý logic khi quá trình streaming chat kết thúc
                System.out.println("Stream chat completed.");
            }
        });

        // Gửi tin nhắn trong luồng streaming chat
        streamChatRequestObserver.onNext(Chat.ChatMessage.newBuilder().setSender("Client1").setContent("Streaming Hello").build());
        // Kết thúc luồng streaming chat
        streamChatRequestObserver.onCompleted();

        // Đóng kết nối khi cần
        channel.shutdown();
    }
}
