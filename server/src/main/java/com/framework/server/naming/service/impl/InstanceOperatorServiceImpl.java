package com.framework.server.naming.service.impl;

import com.framework.server.core.manager.impl.BaseClientManager;
import com.framework.server.naming.pojo.ClientAttributes;
import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.pojo.Service;
import com.framework.server.naming.service.InstanceOperatorService;
import com.framework.server.naming.util.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InstanceOperatorServiceImpl implements InstanceOperatorService {
    @Autowired
    private BaseClientManager clientManager;

    @Override
    public void createInstance(InstanceServicePo instancePo) {
        // 入参校验
        NamingUtils.checkInstance(instancePo);

        // 获取clientId
        String clientId = instancePo.getClientId();

        // 获取客户端
        createIpClient(clientId);

        // 获取实例
        Service service = getService(instancePo.getNamespaceId(),
                instancePo.getServiceName(), instancePo.isEphemeral());

        // 进行注册
    }

    private Service getService(String namespaceId, String serviceName, boolean ephemeral) {
        String groupName = NamingUtils.getGroupName(serviceName);
        String serviceNameNoGrouped = NamingUtils.getServiceName(serviceName);
        return Service.newService(namespaceId, groupName, serviceNameNoGrouped, ephemeral);
    }

    private void createIpClient(String clientId) {
        if (clientManager.contains(clientId)) {
            clientManager.clientConnected(clientId, new ClientAttributes());
        }
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
