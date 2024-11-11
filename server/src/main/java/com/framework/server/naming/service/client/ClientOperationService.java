package com.framework.server.naming.service.client;

import com.framework.server.naming.pojo.InstanceServicePo;
import com.framework.server.naming.pojo.Service;

public interface ClientOperationService {
    boolean registeredInstance(Service service, InstanceServicePo instancePo, String clientId);
}
