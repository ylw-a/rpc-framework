package com.framework.client.service;

import com.common.HelloServiceGrpc;
import com.common.UserProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

    @GrpcClient("server")
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    @RequestMapping("/hello")
    public String sayHello() {
        UserProto.RequestBody.Builder builder = UserProto.RequestBody.newBuilder();
        builder.setAge(12);
        builder.setName("common api");
        UserProto.RequestBody build = builder.build();

        UserProto.ResponseBody responseBody = helloServiceBlockingStub.sayHello(build);
        return responseBody.getMessage();
    }
}
