package com.baymini.katsura.s0205_handler;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private Button button;
    private android.os.Handler handler;
    private TextView textView;

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

        button = (Button)findViewById(R.id.buttonId);
        textView = (TextView)findViewById(R.id.textViewId);

        handler = new FirstHandler();
        button.setOnClickListener(new ButtonListener());

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

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            Thread t = new NetworkThread();
            t.start();
        }
    }

    class FirstHandler extends android.os.Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            System.out.println("handleMessage---->" + Thread.currentThread().getName());
            String S = (String)msg.obj;
            textView.setText(S);
        }
    }

    class NetworkThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("network---->" + Thread.currentThread().getName());
            try {
                Thread.sleep(2 * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            String s = "从网络中中获取的数据";
            //只能在ui线程中修改ui
            Message msg = handler.obtainMessage();
            msg.obj = s;
            handler.sendMessage(msg);
        }
    }
}
