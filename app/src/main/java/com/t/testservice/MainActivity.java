package com.t.testservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ServiceConnection connection;
    private Myservice getinstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        connection = new ServiceConnection() {

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Myservice.myibinder myibinder = (Myservice.myibinder) service;
                getinstance = myibinder.getinstance();
                // 这个是实现接口的方式。
                Myinterface inter= (Myinterface)service;
                inter.eat();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

    }

    public void haha(View view) {
        startService(new Intent(this, Myservice.class));

    }

    public void hehe() {
        Intent intent = new Intent(MainActivity.this,Myservice.class);
        bindService(intent,connection, Service.BIND_AUTO_CREATE);
    }


    public void bind(View view){
        hehe();
    }

    public void unbind(View view){
        unbindService(connection);
    }


    public void todo(View view){
        getinstance.time();
    }


}
