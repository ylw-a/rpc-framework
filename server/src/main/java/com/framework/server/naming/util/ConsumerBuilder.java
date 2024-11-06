package com.framework.server.naming.util;

/**
 * 函数式接口
 *
 * @param <O> obj 对象
 * @param <P> param 属性参数
 */
interface ConsumerBuilder<O, P> {
    void accept(O object, P param);
}
