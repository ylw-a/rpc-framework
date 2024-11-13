package com.framework.server.notify;

import com.framework.server.naming.pojo.Subscriber;

import java.io.Closeable;

/**
 * 事件发布者接口。
 *
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 * @author zongtanghu
 */
public interface EventPublisher extends Closeable {

    /**
     * 初始化事件发布者。
     *
     * @param type       事件类型
     * @param bufferSize 消息暂存队列大小
     */
    void init(Class<? extends Event> type, int bufferSize);

    /**
     * 获取当前暂存的事件数量。
     *
     * @return 事件数量
     */
    long currentEventSize();

    /**
     * 添加监听器。
     *
     * @param subscriber 订阅者
     */
    void addSubscriber(Subscriber subscriber);

    /**
     * 移除监听器。
     *
     * @param subscriber 订阅者
     */
    void removeSubscriber(Subscriber subscriber);

    /**
     * 发布事件。
     *
     * @param event 事件
     * @return 事件发布是否成功
     */
    boolean publish(Event event);

    /**
     * 通知监听器。
     *
     * @param subscriber 订阅者
     * @param event      事件
     */
    void notifySubscriber(Subscriber subscriber, Event event);

}
