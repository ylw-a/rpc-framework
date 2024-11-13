package com.framework.server.notify;

import com.framework.server.naming.exception.ServerException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个用于加载服务的类
 *
 * @author xiweng.yy
 */
public class NacosServiceLoader {
    /**
     * 用于缓存已加载的服务类
     */
    private static final Map<Class<?>, Collection<Class<?>>> SERVICES = new ConcurrentHashMap<>();

    /**
     * <h1>用于加载指定服务类的的所有实现</h1>
     * <p>如果SERVICES已经缓存了该服务类的实现，则从缓存返回，否则使用ServiceLoader.load(service)加载该服务类的所有实现，
     * 并添加到结果集和缓存中</p>
     *
     * @param service service class
     * @return service instances
     * @param <T> t
     */
    public static <T> Collection<T> load(final Class<T> service) {
        if (SERVICES.containsKey(service)) {
            return newServiceInstances(service);
        }
        Collection<T> result = new LinkedHashSet<>();
        for (T each : ServiceLoader.load(service)) {
            result.add(each);
            cacheServiceClass(service, each);
        }
        return result;
    }

    /**
     * 进行缓存
     *
     * @param service service class
     * @param instance i
     * @param <T> t
     */
    private static <T> void cacheServiceClass(final Class<T> service, final T instance) {
        SERVICES.computeIfAbsent(service, k -> new LinkedHashSet<>()).add(instance.getClass());
    }

    /**
     * 从缓存中创建新的服务实例
     *
     * @param service service
     * @return service instances
     * @param <T> t
     */
    public static <T> Collection<T> newServiceInstances(final Class<T> service) {
        // 如果缓存中有该服务类，则从缓存中创建新的服务实例，否则返回空集合
        return SERVICES.containsKey(service) ? newServiceInstancesFromCache(service) : Collections.<T>emptyList();
    }

    /**
     * 从缓存中创建新的服务实例
     *
     * @param service service
     * @return service instances
     * @param <T> t
     */
    @SuppressWarnings("unchecked")
    private static <T> Collection<T> newServiceInstancesFromCache(Class<T> service) {
        Collection<T> result = new LinkedHashSet<>();
        for (Class<?> each : SERVICES.get(service)) {
            result.add((T) newServiceInstance(each));
        }
        return result;
    }

    /**
     * 创建新的实例
     *
     * @param clazz 类
     * @return 新的实例
     */
    private static Object newServiceInstance(final Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new ServerException(e.getMessage());
        }
    }
}
