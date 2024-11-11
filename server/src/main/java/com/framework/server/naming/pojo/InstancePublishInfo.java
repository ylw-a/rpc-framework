package com.framework.server.naming.pojo;

import lombok.Data;

import java.util.Map;

/**
 * 服务发布信息
 */
@Data
public class InstancePublishInfo {
    /**
     * ip
     */
    private String ip;

    /**
     * 端口
     */
    private int port;

    /**
     * 健康状态
     */
    private boolean healthy;

    /**
     * 集群名称
     */
    private String cluster;

    /**
     * 扩展信息
     */
    private Map<String, Object> extendDatum;
}
