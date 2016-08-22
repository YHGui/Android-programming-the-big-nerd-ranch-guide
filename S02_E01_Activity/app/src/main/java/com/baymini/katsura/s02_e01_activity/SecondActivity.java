package com.baymini.katsura.s02_e01_activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Katsura on 2016-03-26.
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        System.out.println("SecondActivity:onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("SecondActivity:onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("SecondActivity:onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("SecondActivity:onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("SecondActivity:onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("SecondActivity:onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("SecondActivity:onStart");
    }
}
