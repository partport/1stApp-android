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
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.graphics.Canvas;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Panupong on 4/19/2016.
 */
public class page_4 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(new MyView(this));
    }
    public class MyView extends View {
        Paint paint;
        Context drawContext;
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        float maxWidth = metrics.widthPixels;
        float maxHeight = metrics.heightPixels;
        float minWidth = 50;
        float minHeight = 50;
        Random r = new Random();
        int radius = r.nextInt(200-50)+50;
        float ww = r.nextFloat()*(maxWidth-minWidth)+minWidth;
        float hh = r.nextFloat()*((maxHeight-300)-minHeight)+minHeight;


        public MyView(Context context){
            super(context);
            this.drawContext = context;
            paint = new Paint();
        }
        @Override
        protected void onDraw(Canvas canvas) {
            // TODO Auto-generated method stub
            super.onDraw(canvas);
            Log.d("r",String.valueOf(radius));
            Log.d("w",String.valueOf(ww));
            Log.d("H",String.valueOf(hh));
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.DKGRAY);
            canvas.drawCircle(ww, hh, radius, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            float y = event.getY();
            float x = event.getX();

            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:

                    if (inCircle(event.getX(), event.getY(), ww, hh, radius)) {
                    //if( x > ww-100 && x < ww+100  && y > hh-100 && y < hh+100 ){
                        Log.d("w",String.valueOf(ww));
                        Log.d("H",String.valueOf(hh));
                        Log.d("TT","x"+x+"y"+y);
                        Snackbar.make(getRootView(),"TouchX"+x+"TouchY"+y,Snackbar.LENGTH_SHORT).show();

                        setContentView(new MyView(getBaseContext()));
                        break;
                    }
                return true;
            }
            return super.onTouchEvent(event);
        }
        private boolean inCircle(float x, float y, float circleCenterX, float circleCenterY, float circleRadius) {
            double dx = Math.pow(x - circleCenterX, 2);
            double dy = Math.pow(y - circleCenterY, 2);

            if ((dx + dy) < Math.pow(circleRadius, 2)) {
                return true;
            } else {
                return false;
            }
        }
    }

}
