package com.framework.server.core.manager;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.framework.server.naming.pojo.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceManager {
    private static final ServiceManager INSTANCE = new ServiceManager();

    /**
     * 服务
     */
    private final ConcurrentHashMap<Service, Service> singletonRepository;

    /**
     * 命名空间服务集合
     */
    private final ConcurrentHashMap<String, Set<Service>> namespaceSingletonMaps;

    private ServiceManager() {
        singletonRepository = new ConcurrentHashMap<>();
        namespaceSingletonMaps = new ConcurrentHashMap<>();
    }

    /**
     * 单例
     *
     * @return ServiceManager
     */
    public static ServiceManager getInstance() {
        return INSTANCE;
    }

    public Service getSingleton(Service service) {
        Service result = singletonRepository.computeIfAbsent(service, key -> {
            // 元数据变化
            // NotifyCenter.publishEvent(new MetadataEvent.ServiceMetadataEvent(service, false));
            return service;
        });
        namespaceSingletonMaps.computeIfAbsent(result.getNamespace(), namespace -> new ConcurrentHashSet<>()).add(result);
        return result;
    }
}
