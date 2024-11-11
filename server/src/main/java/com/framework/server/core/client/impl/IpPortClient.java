package com.framework.server.core.client.impl;

import com.framework.server.core.client.BaseClient;
import com.framework.server.naming.pojo.*;
import lombok.Data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Data
public class IpPortClient implements BaseClient {
    /**
     * 服务发布信息
     */
    public final ConcurrentHashMap<Service, InstancePublishInfo> publishers = new ConcurrentHashMap<>();

    /**
     * 服务订阅者
     */
    protected final ConcurrentHashMap<Service, Subscriber> subscribers = new ConcurrentHashMap<>();

    /**
     * 上次更新时间
     */
    protected volatile long lastUpdatedTime;

    /**
     * 版本号
     */
    protected final AtomicLong revision;

    /**
     * 客户端属性
     */
    protected ClientAttributes attributes;
    @Override
    public String getClientId() {
        return "";
    }

    @Override
    public boolean isEphemeralClient() {
        return false;
    }

    @Override
    public void setLastUpdateTime() {

    }

    @Override
    public long getLastUpdateTime() {
        return 0;
    }

    @Override
    public void addServiceInstance(String serviceName, InstanceServicePo instancePo) {

    }

    @Override
    public void removeServiceInstance(InstanceServicePo instancePo) {

    }

    @Override
    public InstanceServicePo getServiceInstance(String serviceName) {
        return null;
    }

    @Override
    public String[] getServiceNames() {
        return new String[0];
    }

    @Override
    public void addServiceSubscriber(String serviceName, String clientId) {

    }

    @Override
    public void removeServiceSubscriber(String serviceName, String clientId) {

    }

    @Override
    public String[] getServiceSubscribers(String serviceName) {
        return new String[0];
    }

    @Override
    public String generateSyncData() {
        return "";
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void release() {

    }

    @Override
    public void reCalculateRevision() {

    }

    @Override
    public long getRevision() {
        return 0;
    }

    @Override
    public void setRevision(long revision) {

    }
}
