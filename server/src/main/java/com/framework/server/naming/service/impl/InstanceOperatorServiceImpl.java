package com.framework.server.naming.service.impl;

import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.service.InstanceOperatorService;
import com.framework.server.naming.util.NamingUtils;
import org.springframework.stereotype.Service;

@Service
public class InstanceOperatorServiceImpl implements InstanceOperatorService {
    @Override
    public void createInstance(InstanceServicePo instancePo) {
        // 入参校验
        NamingUtils.checkInstance(instancePo);

        // 获取clientId
        String clientId = instancePo.getClientId();

        // 获取客户端
        // 获取实例
        // 进行注册
    }

    @Override
    public boolean updateInstance(InstanceServicePo instancePo) {
        // todo 待实现
        return false;
    }

    @Override
    public boolean deleteInstance(String serviceName) {
        // todo 待实现
        return false;
    }
}
