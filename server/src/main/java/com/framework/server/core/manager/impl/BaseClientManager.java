package com.framework.server.core.manager.impl;

import com.framework.server.core.client.BaseClient;
import com.framework.server.core.manager.ClientManager;
import com.framework.server.naming.pojo.ClientAttributes;
import com.framework.server.naming.util.NamingConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseClientManager implements ClientManager {
    @Autowired
    private EphemeralClientManager ephemeralClientManager;

    @Autowired
    private PersistenceClientManager persistenceClientManager;

    @Override
    public boolean contains(String clientId) {
        return ephemeralClientManager.contains(clientId) || persistenceClientManager.contains(clientId);
    }

    @Override
    public BaseClient getClient(String clientId) {
        return getClientManager(clientId).getClient(clientId);
    }

    @Override
    public boolean clientConnected(String clientId, ClientAttributes attributes) {
        return getClientManager(clientId).clientConnected(clientId, attributes);
    }

    private ClientManager getClientManager(String clientId) {
        return clientId.endsWith(NamingConstant.FALSE) ? ephemeralClientManager : persistenceClientManager;
    }
}
