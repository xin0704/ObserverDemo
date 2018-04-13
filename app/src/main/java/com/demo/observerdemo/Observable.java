package com.demo.observerdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/10.
 * <p>
 * 被观察者
 */

public class Observable<T> {

    //被观察者会有很多个观察者  用List把他们装起来
    private List<Observer<T>> list = new ArrayList<>();


    //订阅被观察者
    public void register(Observer<T> observer) {

        if (observer == null) {
            throw new NullPointerException("观察者不能为空");
        }

        //判断 此观察者 是否已经订阅过 被观察者 了

        if (!list.contains(observer)) {
            list.add(observer);
        }
    }

    //取消订阅
    public synchronized void unRegister(Observer<T> observer) {

        list.remove(observer);

    }

    //通知观察者 数据发生改变
    public void notifyObservers(T data) {

        for (Observer<T> observer : list) {
            observer.onUpdate(this, data);
        }

    }

}
