package com.framework.server.naming.service.client.impl;

import com.framework.server.core.manager.ServiceManager;
import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.pojo.Service;
import com.framework.server.naming.service.client.ClientOperationService;
import com.framework.server.naming.util.NamingUtils;
import org.springframework.stereotype.Component;

@Component
public class EphemeralClientOperationServiceImpl implements ClientOperationService {
    @Override
    public boolean registeredInstance(Service service, InstanceServicePo instancePo, String clientId) {
        NamingUtils.checkInstance(instancePo);

        ServiceManager.getInstance().getSingleton(service);

        // todo 事件发布
        return true;
    }
}
