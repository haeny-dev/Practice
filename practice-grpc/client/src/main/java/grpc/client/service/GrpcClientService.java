package grpc.client.service;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.grpc.examples.lib.HelloReply;
import org.grpc.examples.lib.HelloRequest;
import org.grpc.examples.lib.HelloServiceGrpc.HelloServiceBlockingStub;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private HelloServiceBlockingStub helloServiceStub;

    public String sendMessage(String name) {
        try {
            HelloReply response = helloServiceStub.sayHello(HelloRequest.newBuilder()
                    .setName(name)
                    .build());
            return response.getMessage();
        } catch (StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
