package com.example.katsura.last_layout;

import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;

import java.net.PortUnreachableException;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private RatingBar ratingBar;
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

        seekBar = (SeekBar)findViewById(R.id.firstSeekBar);
        seekBar.setProgress(30);
        seekBar.setSecondaryProgress(50);

        ratingBar = (RatingBar)findViewById(R.id.firstRatingBar);
        RatingBarListener ratingBarListener = new RatingBarListener();
        ratingBar.setOnRatingBarChangeListener(ratingBarListener);


        SeekBarListener seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);

        button = (Button)findViewById(R.id.button);
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

    class  SeekBarListener implements SeekBar.OnSeekBarChangeListener
    {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            System.out.println("Progress: " + progress + ",fromUser " + fromUser);

        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar)
        {
            System.out.println("onStart");

        }

        public void onStopTrackingTouch(SeekBar seekBar)
        {
            System.out.println("onStop");
        }
    }

    class RatingBarListener implements RatingBar.OnRatingBarChangeListener
    {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
        {
            System.out.println("rating: " + rating + ",fromUser: " + fromUser);
        }
    }

    class ButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            ratingBar.setRating(ratingBar.getRating() + 1.0f);
        }
    }
}
