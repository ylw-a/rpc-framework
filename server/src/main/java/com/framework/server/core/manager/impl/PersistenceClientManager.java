package com.framework.server.core.manager.impl;

import com.framework.server.core.client.BaseClient;
import com.framework.server.core.manager.ClientManager;
import com.framework.server.naming.pojo.ClientAttributes;
import org.springframework.stereotype.Component;

@Component
public class PersistenceClientManager implements ClientManager {
    @Override
    public boolean contains(String clientId) {
        return false;
    }

    @Override
    public BaseClient getClient(String clientId) {
        return null;
    }

    @Override
    public boolean clientConnected(String clientId, ClientAttributes attributes) {
        return false;
    }
}
