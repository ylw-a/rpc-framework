package com.framework.server.core.client;

import com.framework.server.naming.pojo.InstancePublishInfo;
import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.pojo.Service;

/**
 * 客户端接口
 */
public interface BaseClient {
    /**
     * 获取客户端唯一标识
     */
    String getClientId();

    /**
     * 判断是否是临时客户端
     *
     * @return 时间戳
     */
    boolean isEphemeralClient();

    /**
     * 设置客户端最后更新时间
     */
    void setLastUpdateTime();

    /**
     * 获取客户端最后更新时间
     *
     * @return 时间戳
     */
    long getLastUpdateTime();

    /**
     * 添加服务实例
     *
      * @param service 服务名称
     * @param instancePo 服务对象
     */
    void addServiceInstance(Service service, InstancePublishInfo instancePo);

    /**
     * 移除服务实例
     *
     * @param instancePo 服务对象
     */
    void removeServiceInstance(InstanceServicePo instancePo);

    /**
     * 获取服务实例信息
     *
     * @param serviceName 服务名称
     * @return 服务对象
     */
    InstanceServicePo getServiceInstance(String serviceName);

    /**
     * 获取所有已发布服务
     *
     * @return 服务名称数组
     */
    String[] getServiceNames();

    /**
     * 添加服务订阅者
     *
     * @param serviceName 服务名称
     * @param clientId 客户端唯一标识
     */
    void addServiceSubscriber(String serviceName, String clientId);

    /**
     * 移除服务订阅者
     *
     * @param serviceName 服务名称
     * @param clientId 客户端唯一标识
     */
    void removeServiceSubscriber(String serviceName, String clientId);

    /**
     * 获取服务订阅者
     *
     * @param serviceName 服务名称
     * @return 服务订阅者列表
     */
    String[] getServiceSubscribers(String serviceName);

    /**
     * 生成同步数据
     *
     * @return 同步数据
     */
    String generateSyncData();

    /**
     * 检查客户端是否过期
     *
     * @return 是否过期
     */
    boolean isExpired();

    /**
     * 释放客户端资源
     */
    void release();

    /**
     * 重新计算客户端修订版本
     */
    void reCalculateRevision();

    /**
     * 获取客户端修订版本
     *
     * @return 修订版本
     */
    long getRevision();

    /**
     * 设置客户端修订版本
     *
     * @param revision 修订版本
     */
    void setRevision(long revision);
}
