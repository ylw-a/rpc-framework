package com.framework.server.naming.service.client.impl;

import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.pojo.Service;
import com.framework.server.naming.service.client.ClientOperationService;
import org.springframework.stereotype.Component;

@Component
public class PersistenceClientOperationServiceImpl implements ClientOperationService {
    @Override
    public boolean registeredInstance(Service service, InstanceServicePo instancePo, String clientId) {
        return false;
    }
}
