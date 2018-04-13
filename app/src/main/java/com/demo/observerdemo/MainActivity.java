package com.demo.observerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Observable<Weather> observable = new Observable<>();//被观察者  天气

    private Observer<Weather> observer1;//观察者1

    private Observer<Weather> observer2;//观察者2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initObserver1();

        initObserver2();

    }

    private void initObserver1() {

        observer1 = new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {

                Log.d("=====第一个观察者======", data.toString());

            }
        };
    }

    private void initObserver2() {

        observer2 = new Observer<Weather>() {
            @Override
            public void onUpdate(Observable<Weather> observable, Weather data) {

                Log.d("=====第二个观察者======", data.toString());

            }
        };

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_one:

                observable.register(observer1);

                break;
            case R.id.register_two:

                observable.register(observer2);

                break;
            case R.id.unregister_one:

                observable.unRegister(observer1);

                break;
            case R.id.unregister_two:

                observable.unRegister(observer2);

                break;
            case R.id.notify:

                Weather weather = new Weather.Builder()
                        .setDate("2018.4.10")
                        .setDesc("阴转多云")
                        .build();

                observable.notifyObservers(weather);

                break;
        }
    }
}
