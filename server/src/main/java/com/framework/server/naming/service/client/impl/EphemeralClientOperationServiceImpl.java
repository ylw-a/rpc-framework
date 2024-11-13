package com.framework.server.naming.service.client.impl;

import com.framework.server.core.client.BaseClient;
import com.framework.server.core.manager.ClientManager;
import com.framework.server.core.manager.ServiceManager;
import com.framework.server.core.manager.impl.BaseClientManager;
import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.pojo.Service;
import com.framework.server.naming.service.client.ClientOperationService;
import com.framework.server.naming.util.NamingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EphemeralClientOperationServiceImpl implements ClientOperationService {
    @Autowired
    private BaseClientManager clientManager;
    @Override
    public boolean registeredInstance(Service service, InstanceServicePo instancePo, String clientId) {
        NamingUtils.checkInstance(instancePo);

        Service singleton = ServiceManager.getInstance().getSingleton(service);

        // todo 事件发布
        BaseClient client = clientManager.getClient(clientId);
        client.addServiceInstance(singleton, instancePo);
        client.setLastUpdateTime();
        client.reCalculateRevision();

        return true;
    }
}
