package grpc.server.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.grpc.examples.lib.HelloReply;
import org.grpc.examples.lib.HelloRequest;
import org.grpc.examples.lib.HelloServiceGrpc;

@GrpcService
public class GrpcHelloServerService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
