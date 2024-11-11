package com.framework.server.naming.pojo;

import lombok.Data;

@Data
public class Subscriber {
    /**
     * ip:port
     */
    private String addrStr;

    /**
     * agent
     */
    private String agent;

    /**
     * app
     */
    private String app;

    /**
     * ip
     */
    private String ip;

    /**
     * port
     */
    private int port;

    /**
     * 命名空间
     */
    private String namespaceId;

    /**
     * 服务名
     */
    private String serviceName;

    /**
     * 集群名
     */
    private String cluster;
}
