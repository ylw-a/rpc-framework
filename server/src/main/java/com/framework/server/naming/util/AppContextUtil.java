package com.framework.server.naming.util;

import com.framework.server.naming.exception.ServerException;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

/**
 * 上下文工具类
 */
public final class AppContextUtil {
    private AppContextUtil() {}

    @Setter
    private static ApplicationContext applicationContext;

    /**
     * 获取applicationContext
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            throw new ServerException("applicationContext is null");
        }
        return applicationContext;
    }

    /**
     * 根据bean名称获取bean
     *
     * @param clazz 目标类型
     * @return 目标bean
     * @param <T> 目标类型
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 根据bean名称获取bean
     *
     * @param name bean名称
     * @param clazz 目标类型
     * @return 目标bean
     * @param <T> 目标类型
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }
}
