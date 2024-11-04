package com.framework.server.naming.controller;

import com.framework.server.register.InstanceServiceGrpc;
import com.framework.server.register.RegisterService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Controller;

@GrpcService

public class InstanceController extends InstanceServiceGrpc.InstanceServiceImplBase {

    /**
     * <h1>做服务注册</h1>
     * 其中，<code>ip</code>、<code>port</code>、<code>serviceName</code>为必填字段
     *
     * @param request req
     * @param responseObserver resp
     */
    @Override
    public void register(RegisterService.RegisterRequest request,
                         StreamObserver<RegisterService.RegisterResponse> responseObserver) {
        RegisterService.RegisterResponse resp = RegisterService.RegisterResponse.newBuilder()
                .setCode(500).setMessage("Register success").setData("")
                .build();
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}
