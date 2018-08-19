package net.bioker;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class ClientImpl {
    public static void main(String[] args) {
        ManagedChannel channel = null;
        try {
            channel = ManagedChannelBuilder
                    .forAddress("localhost", 8080)
                    .usePlaintext()
                    .build();
            GreeterGrpc.GreeterBlockingStub serviceStub =
                    GreeterGrpc.newBlockingStub(channel);

            System.out.println(serviceStub.greet(Greeting.newBuilder().setName("Java").build()));
        } finally {
            if (channel != null) {
                try {
                    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
