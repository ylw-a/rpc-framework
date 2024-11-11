package com.framework.server.naming.pojo;

import lombok.Data;

import java.util.Map;

/**
 * 客户端属性
 */
@Data
public class ClientAttributes {
    private Map<String, Object> clientAttributes;
}
