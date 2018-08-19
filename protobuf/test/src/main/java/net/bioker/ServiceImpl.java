package net.bioker;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class ServiceImpl extends GreeterGrpc.GreeterImplBase {

    public static void main(String[] args) throws InterruptedException, IOException {
        io.grpc.Server server = ServerBuilder.forPort(8080)
                .addService(new ServiceImpl())
                .build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
        server.awaitTermination();
    }

    @Override
    public void greet(Greeting request, StreamObserver<Empty> responseObserver) {
        System.out.println("Hello, " + request.getName() + "!");
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
