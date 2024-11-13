
package com.framework.server.notify;

import java.util.Collection;
import java.util.Iterator;

/**
 * 统一的事件通知中心
 */
public class NotifyCenter {
    /**
     * 内部 ArrayBlockingQueue 缓冲区大小。对于高写入吞吐量的应用程序，
     * 需要适当增加此值。默认值为 16384。
     */
    public static int ringBufferSize;

    /**
     * 公共发布者的消息暂存队列缓冲区大小，默认值为 1024。
     */
    public static int shareBufferSize;

    /**
     * 当前使用的事件发布者类。
     */
    private static Class<? extends EventPublisher> clazz;

    {
        ringBufferSize = Integer.getInteger("server.notify.ringBufferSize", 16384);

        shareBufferSize = Integer.getInteger("server.notify.shareBufferSize", 1024);

        // 加载所有实现EventPublisher接口的类
        final Collection<EventPublisher> publishers = NacosServiceLoader.load(EventPublisher.class);

        // 迭代器
        Iterator<EventPublisher> iterator = publishers.iterator();

        if (iterator.hasNext()) {
            clazz = iterator.next().getClass();
        } else {
            clazz = DefaultPublisher.class;
        }
    }
}
