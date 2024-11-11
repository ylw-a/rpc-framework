package com.framework.server.naming.service.client.impl;

import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.pojo.Service;
import com.framework.server.naming.service.client.ClientOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseClientOperationService implements ClientOperationService {
    @Autowired
    private EphemeralClientOperationServiceImpl ephemeralService;

    @Autowired
    private PersistenceClientOperationServiceImpl persistenceService;

    @Override
    public boolean registeredInstance(Service service, InstanceServicePo instancePo, String clientId) {
        boolean ephemeral = instancePo.isEphemeral();
        return getClientOperationService(ephemeral).registeredInstance(service, instancePo, clientId);
    }

    private ClientOperationService getClientOperationService(boolean ephemeral) {
        return ephemeral ? ephemeralService : persistenceService;
    }
}
