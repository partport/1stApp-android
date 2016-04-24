package com.example.panupong.firstapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Canvas;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Panupong on 4/19/2016.
 */
public class page_4 extends AppCompatActivity {
    int count = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(new MyView(this));
        setContentView(R.layout.activity_page4);
        final canvasView myView = (canvasView)findViewById(R.id.cview);
        final Button btn1 = (Button)findViewById(R.id.random);
        final Button btn2 = (Button)findViewById(R.id.start);
        final TextView tv1 = (TextView) findViewById(R.id.tv_score);
        final TextView tv_time = (TextView) findViewById(R.id.tv_time);
        btn1.setVisibility(View.INVISIBLE);
        myView.setVisibility(View.INVISIBLE);
        tv_time.setText("00:00");
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                myView.onRandom();
                myView.invalidate();
                tv1.setText("Score=" + myView.getPoint());
                handler.postDelayed(this,400);
            }
        });
       btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setVisibility(View.INVISIBLE);
                new CountDownTimer(60000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        tv_time.setText(getTimeFormat(millisUntilFinished));
                        myView.setVisibility(View.VISIBLE);

                    }
                    public void onFinish() {
                        //tv_time.setText("GAME OVER WHEN HIT 10 TIME ");
                        btn1.setVisibility(View.VISIBLE);
                        myView.setVisibility(View.INVISIBLE);
                        tv1.setText("Score=" + myView.getPoint());
                        tv_time.setText("0");
                        btn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                myView.rePoint();
                                myView.onRandom();
                                btn1.setVisibility(View.INVISIBLE);
                                myView.setVisibility(View.VISIBLE);
                                myView.invalidate();
                                btn2.setVisibility(View.VISIBLE);
                                btn2.callOnClick();
                            }
                        });
                    }
                }.start();

            }
        });

    }
    public String getTimeFormat (long ms){
        String temp;
        DateFormat outFormat = new SimpleDateFormat("mm:ss");
        Date d = new Date(ms);
        temp = outFormat.format(d);
        return temp;
    }


}
