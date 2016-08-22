package com.baymini.katsura.s02e04_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Katsura on 2016-03-27.
 */
public class OtherActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otheractivity);

        Intent intent = getIntent();
        int age = intent.getIntExtra("age", 20);
        String name = intent.getStringExtra("Name");

        textView = (TextView)findViewById(R.id.otherTextView);
        textView.setText(name + ": " + age);
    }
}
