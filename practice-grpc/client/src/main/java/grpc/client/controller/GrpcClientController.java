package grpc.client.controller;

import grpc.client.service.GrpcClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GrpcClientController {

    private final GrpcClientService grpcClientService;

    @GetMapping("/hello")
    public String printMessage(@RequestParam String name) {
        return grpcClientService.sendMessage(name);
    }
}
