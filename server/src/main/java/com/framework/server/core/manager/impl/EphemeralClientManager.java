package com.framework.server.core.manager.impl;

import com.framework.server.core.client.BaseClient;
import com.framework.server.core.client.impl.IpPortClient;
import com.framework.server.core.manager.ClientManager;
import com.framework.server.naming.pojo.ClientAttributes;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class EphemeralClientManager implements ClientManager {

    private final ConcurrentMap<String, IpPortClient> clients = new ConcurrentHashMap<>();
    @Override
    public boolean contains(String clientId) {
        return clientId.contains(clientId);
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
