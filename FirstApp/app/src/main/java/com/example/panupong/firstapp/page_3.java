package com.example.panupong.firstapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

/**
 * Created by Panupong on 4/18/2016.
 */
public class page_3 extends AppCompatActivity {
    private static final int LONG_DELAY = 1000;
    int num =0;
    boolean isPressed =false;
    final Handler handler = new Handler();
    TextView tv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);


        final TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText("Press ME!");
        tv2 = (TextView) findViewById(R.id.tv2) ;
        tv2.setText("");
        tv1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d("TouchTest", "Touch down");
                    pressDown();
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    Log.d("TouchTest", "Touch up");
                    pressUp();
                }
                return true;
            }
        });

    }
    private void pressDown(){
        isPressed = true;
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(isPressed){
                    num++;
                    Log.d("num",String.valueOf(num));
                    tv2.setText(String.valueOf(num));

                   final Toast to = Toast.makeText(getApplicationContext(),String.valueOf(num),Toast.LENGTH_SHORT);
                    to.show();

                    Handler hh = new Handler();
                    hh.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            to.cancel();
                        }
                    },500);

                    handler.postDelayed(this,1000);

                }
            }
        });
    }
    private void pressUp(){
        isPressed = false;
        num=0;
        tv2.setText("");

    }

}

