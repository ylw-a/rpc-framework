package com.framework.server.naming.service;

import com.framework.server.naming.pojo.InstanceServicePo;

/**
 * 操作服务
 */
public interface InstanceOperatorService {
    /**
     * 创建服务
     *
     * @param instancePo 服务信息
     */
    void createInstance(InstanceServicePo instancePo);

    /**
     * 更新服务
     *
     * @param instancePo 服务信息
     * @return boolean
     */
    boolean updateInstance(InstanceServicePo instancePo);

    /**
     * 删除服务
     *
     * @param serviceName 服务名
     * @return boolean
     */
    boolean deleteInstance(String serviceName);
}
