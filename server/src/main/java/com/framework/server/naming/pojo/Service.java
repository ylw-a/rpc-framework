package com.framework.server.naming.pojo;

import lombok.Data;

import java.util.concurrent.atomic.AtomicLong;

@Data
public class Service {
    /**
     * 命名空间
     */
    private final String namespace;

    /**
     * 服务组
     */
    private final String group;

    /**
     * 服务名
     */
    private final String name;

    /**
     * 是否是临时实例
     */
    private final boolean ephemeral;

    /**
     * 版本号
     */
    private final AtomicLong revision = new AtomicLong(1L);

    /**
     * 上次更新时间
     */
    private long lastUpdatedTime;

    public Service(String namespace, String group, String name, boolean ephemeral) {
        this.namespace = namespace;
        this.group = group;
        this.name = name;
        this.ephemeral = ephemeral;
    }

    public static Service newService(String namespace, String group, String name, boolean ephemeral) {
        return new Service(namespace, group, name, ephemeral);
    }
}
