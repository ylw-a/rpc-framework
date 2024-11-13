package com.framework.server.notify;

import com.framework.server.naming.pojo.Subscriber;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.framework.server.notify.NotifyCenter.ringBufferSize;

public class DefaultPublisher extends Thread implements EventPublisher {

    private Class<? extends Event> eventType;

    private volatile boolean initialized = false;

    private int queueMaxSize = -1;

    private BlockingQueue<Event> queue;

    @Override
    public void init(Class<? extends Event> type, int bufferSize) {
        setDaemon(true);
        setName("nacos.publisher-" + type.getName());
        this.eventType = type;
        this.queueMaxSize = bufferSize;
        if (this.queueMaxSize == -1) {
            this.queueMaxSize = ringBufferSize;
        }
        this.queue = new ArrayBlockingQueue<>(this.queueMaxSize);
        start();
    }

    @Override
    public synchronized void start() {
        if (!initialized) {
            // start just called once
            super.start();
            initialized = true;
        }
    }

    @Override
    public long currentEventSize() {
        return 0;
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    @Override
    public boolean publish(Event event) {
        return false;
    }

    @Override
    public void notifySubscriber(Subscriber subscriber, Event event) {

    }

    @Override
    public void close() throws IOException {

    }
}
