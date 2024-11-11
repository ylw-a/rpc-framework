package com.framework.server.core.manager;

import com.framework.server.core.client.BaseClient;
import com.framework.server.naming.pojo.ClientAttributes;
import org.springframework.stereotype.Component;

/**
 * 客户端管理器
 */
public interface ClientManager {
    boolean contains(String clientId);

    BaseClient getClient(String clientId);

    boolean clientConnected(String clientId, ClientAttributes attributes);
}
