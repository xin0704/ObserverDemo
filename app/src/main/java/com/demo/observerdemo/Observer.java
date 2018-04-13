package com.demo.observerdemo;

/**
 * Created by admin on 2018/4/10.
 */

public interface Observer<T> {

    void onUpdate(Observable<T> observable, T data);

}
