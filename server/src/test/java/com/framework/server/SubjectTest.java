package com.framework.server;

import java.util.ArrayList;
import java.util.List;

// 主题接口
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Event event);
}

// 观察者接口
interface Observer {
    void onEvent(Event event);
}

// 事件接口
interface Event {
    String getMessage();
}

// 具体主题
class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Event event) {
        for (Observer observer : observers) {
            observer.onEvent(event);
        }
    }

    public void publishEvent(Event event) {
        notifyObservers(event);
    }
}

// 具体观察者
class ConcreteObserver implements Observer {
    @Override
    public void onEvent(Event event) {
        System.out.println("Received event: " + event.getMessage());
    }
}

class TwoObserver implements Observer {

    @Override
    public void onEvent(Event event) {
        System.out.println("这是第二个观察者：msg：=》" + event.getMessage());
    }
}

class ThreeObserver implements Observer {

    @Override
    public void onEvent(Event event) {
        System.out.println("这是第三个观察者，msg=》" + event.getMessage());
    }
}

// 具体事件
class ConcreteEvent implements Event {
    private String message;

    public ConcreteEvent(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

// 测试
class ObserverPatternExample {
    public static void main(String[] args) {
        // 定义主题
        ConcreteSubject subject = new ConcreteSubject();

        // 定义观察者
        Observer observer = new ConcreteObserver();

        // 注册观察者
        subject.registerObserver(observer);

        System.out.println("第一次发布。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");

        // 事件发布，原理就是，观察者注册到主题后，主题会在发布事件的时候挨个遍历所有观察者，并调用观察者的事件执行方法
        subject.publishEvent(new ConcreteEvent("Hello, Observer Pattern!"));

        TwoObserver twoObserver = new TwoObserver();
        System.out.println("移除第一个观察者并加入第二个");
        subject.registerObserver(twoObserver);
        subject.removeObserver(observer);

        System.out.println("第二次发布。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        subject.publishEvent(new ConcreteEvent("哈哈哈"));

        ThreeObserver threeObserver = new ThreeObserver();
        System.out.println("加入第三个");
        subject.registerObserver(threeObserver);

        System.out.println("第三次发布。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        subject.publishEvent(new ConcreteEvent("嘿嘿嘿"));
    }
}
