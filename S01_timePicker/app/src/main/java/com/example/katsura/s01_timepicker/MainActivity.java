package com.example.katsura.s01_timepicker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private TimePicker firstTimePicker;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        firstTimePicker = (TimePicker) findViewById(R.id.firstTimePicker);
        TimeListener timeListener = new TimeListener();
        firstTimePicker.setOnTimeChangedListener(timeListener);
        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class TimeListener implements TimePicker.OnTimeChangedListener
    {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
        {
            System.out.println("Hour: " + hourOfDay + ",minute: " +minute);
        }
    }

    class ButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            int hour = firstTimePicker.getHour();
            int minute = firstTimePicker.getMinute();
            System.out.println("h: " + hour + ", minute" + minute);
        }

    }
}
