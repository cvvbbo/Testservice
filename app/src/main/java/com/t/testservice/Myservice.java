package com.t.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;

public class Myservice extends Service {


    // todo 一般是在service中的oncreate方法中执行方法。
    private myibinder myibinder = new myibinder();


    public Myservice() {
        time();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Myservice", "onBind");
        return new myibinder();
    }

    class myibinder extends Binder implements Myinterface{

        public myibinder() {
            Log.e("Myservice", "myibinder 方法被执行了");
        }

        // todo 想到service还有一个 ，内部类持有外部类的引用
        public Myservice getinstance(){
            return Myservice.this;
        }

        @Override
        public void eat() {
            Log.e("2020/4/4","eat");
        }

        @Override
        public void live() {
            Log.e("2020/4/4","live");
        }

        @Override
        public void go() {
            Log.e("2020/4/4","go");

        }

        @Override
        public void play() {
            Log.e("2020/4/4","play");

        }
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("Myservice", "onStart");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Myservice", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Myservice", "onDestroy");

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Myservice", "onUnbind");

        return super.onUnbind(intent);

    }


    public void time() {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Log.e("service中的定时器", "haha");
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,1000);
    }


}
