package com.framework.server.naming.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 统一异常处理
 * todo 需要做统一的异常拦截返回
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ServerException extends RuntimeException {
    private int code;

    private String message;

    public ServerException(String message) {
        // todo 后期需要做统一的常量优化
        this.code = 500;
        this.message = message;
    }

    public ServerException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
