package com.framework.server.naming.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class BuilderUtil<T> {
    private final T bean;

    private BuilderUtil(T bean) {
        this.bean = bean;
    }

    private T getBean() {
        return bean;
    }

    /**
     * 获取构建对象
     *
     * @param supplier supplier
     * @param <T> t
     * @return BuilderUtil
     */
    public static <T> BuilderUtil<T> buildBean(Supplier<T> supplier) {
        T obj = supplier.get();
        return new BuilderUtil<>(obj);
    }

    /**
     * 返回对象
     *
     * @return t
     */
    private T resultBean() {
        return getBean();
    }

    /**
     * 属性赋值
     *
     * @param builder builder
     * @param param param
     * @param <P> p
     * @return BuilderUtil
     */
    private <P> BuilderUtil<T> put(ConsumerBuilder<T, P> builder, P param) {
        Consumer<T> consumer = obj -> builder.accept(obj, param);
        consumer.accept(getBean());
        return this;
    }
}
