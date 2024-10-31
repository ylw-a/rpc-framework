package com.framework.server.service;



import com.common.HelloServiceGrpc;
import com.common.UserProto;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(UserProto.RequestBody request, StreamObserver<UserProto.ResponseBody> responseObserver) {
        String name = request.getName();
        int age = request.getAge();

        System.out.println("param name = " + name);
        System.out.println("param age = " + age);

        UserProto.ResponseBody.Builder builder = UserProto.ResponseBody.newBuilder();
        builder.setMessage(" 成功！");
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}
