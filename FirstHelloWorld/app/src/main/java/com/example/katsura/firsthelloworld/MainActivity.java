package com.example.katsura.firsthelloworld;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.net.PortUnreachableException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    int count = 0;

    private CheckBox eatBox;
    private CheckBox sleepBox;
    private CheckBox dotaBox;
    private CheckBox allBox;
    private RadioGroup radioGroup;
    private RadioButton femaleButton;
    private RadioButton maleButton;
    private ImageView imageView1;
    private ImageView imageView2;


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

        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Hello YH Gui");
        textView.setBackgroundColor(Color.BLUE);

        button = (Button)findViewById(R.id.button);
        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);

        eatBox = (CheckBox)findViewById(R.id.eatId);
        sleepBox = (CheckBox)findViewById(R.id.sleepId);
        dotaBox = (CheckBox)findViewById(R.id.dotaId);
        allBox = (CheckBox)findViewById(R.id.allCheckId);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupId);
        femaleButton =(RadioButton)findViewById(R.id.femaleButtonId);
        maleButton = (RadioButton)findViewById(R.id.maleButtonId);

        imageView1 = (ImageView)findViewById(R.id.imageView1Id);
        imageView2 = (ImageView)findViewById(R.id.imageView2Id);
        //imageView.setImageResource(R.drawable.Work);

        imageView1.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CheckBoxListener listener = new CheckBoxListener();
        AllCheckBoxListener allCheckBoxListener = new AllCheckBoxListener();
        RadioGroupListener radioGroupListener = new RadioGroupListener();
        RadioBoxListener radioBoxListener = new RadioBoxListener();

        //eatBox.setOnClickListener(listener);
        //sleepBox.setOnClickListener(listener);
        eatBox.setOnCheckedChangeListener(listener        //dotaBox.setOnClickListener(listener);
        );
        sleepBox.setOnCheckedChangeListener(listener);
        dotaBox.setOnCheckedChangeListener(listener);
        allBox.setOnCheckedChangeListener(allCheckBoxListener);
        radioGroup.setOnCheckedChangeListener(radioGroupListener);
        femaleButton.setOnCheckedChangeListener(radioBoxListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View V){
            count++;
            textView.setText(count + " " + "piece");

        }
    }

    class OnBoxClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View arg0){
            CheckBox box = (CheckBox)arg0;

            System.out.println("id--->" + arg0.getId());
            if(box.isChecked())
            {
                System.out.println("Checked");
            }

            if(box.getId() == R.id.eatId){
                System.out.println("Checkbox is eatBox");
            }
            else if(box.getId() == R.id.sleepId){
                System.out.println("CheckBox is sleepBox");
            }
            else if(box.getId() == R.id.dotaId)
            {
                System.out.println("CheckBox is dotaBox");
            }
        }

    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked)
        {
            if(buttonview.getId() == R.id.eatId)
            {
                System.out.println("eatBox");
            }
            else if(buttonview.getId() == R.id.sleepId)
            {
                System.out.println("sleepBox");
            }
            else if(buttonview.getId() == R.id.dotaId)
            {
                System.out.println("dotaId");
            }

            if(isChecked)
            {
                System.out.println("Checked");
            }
            else
            {
                System.out.println("unchecked");
            }
        }
    }

    class AllCheckBoxListener implements CompoundButton.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked)
        {
            if(isChecked)
            {
                System.out.println("all check");
                eatBox.setChecked(isChecked);
                sleepBox.setChecked(isChecked);
                dotaBox.setChecked(isChecked);
            }
            else
            {
                System.out.println("all unchecked");
                eatBox.setChecked(isChecked);
                sleepBox.setChecked(isChecked);
                dotaBox.setChecked(isChecked);
            }
        }
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            if(checkedId == femaleButton.getId())
            {
                System.out.println("选中了female");
            }
            else if(checkedId == maleButton.getId())
            {
                System.out.println("选中了male");
            }
        }
    }

    class RadioBoxListener implements CompoundButton.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonview, boolean isChecked)
        {
            System.out.println("isChecked--->" + isChecked);
        }

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
}
