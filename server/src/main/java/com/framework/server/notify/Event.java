package com.framework.server.notify;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Event implements Serializable {

    private static final long serialVersionUID = -3731383194964997493L;

    private static final AtomicLong SEQUENCE = new AtomicLong(0);

    private final long sequence = SEQUENCE.getAndIncrement();

    /**
     * 获取事件的序列号，可用于处理事件的顺序。
     *
     * @return 序列号，最好保证其单调递增。
     */
    public long sequence() {
        return sequence;
    }

    /**
     * 获取事件的作用范围。
     *
     * @return 事件作用范围，如果对所有范围有效则返回 null
     */
    public String scope() {
        return null;
    }

    /**
     * 是否为插件事件。如果是插件事件，在没有发布者和订阅者时可以被丢弃且不提示，默认为 false。
     *
     * @return 如果是插件事件返回 {@code true}，否则返回 {@code false}
     */
    public boolean isPluginEvent() {
        return false;
    }
}
