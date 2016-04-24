package com.example.panupong.firstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Panupong on 4/20/2016.
 */
public class canvasView extends View {
    Paint paint;
    Context drawContext;
    float maxWidth,maxHeight;
    float minWidth = 50;
    float minHeight = 80;
    Random r = new Random();
    int radius;
    float ww ;
    float hh;

    int point;

    public canvasView(Context context) {
        super(context);
        init(context);
    }


    public canvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public canvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        this.drawContext = context;
        getDeviceSize();
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);

    }
    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        onRandom();
        Log.d("r", String.valueOf(radius));
        Log.d("w", String.valueOf(ww));
        Log.d("H", String.valueOf(hh));
        canvas.drawCircle(ww, hh, radius, paint);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float y = event.getY();
        float x = event.getX();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (inCircle(event.getX(), event.getY(), ww, hh, radius)) {
                    //if( x > ww-100 && x < ww+100  && y > hh-100 && y < hh+100 ){
//                    Log.d("w", String.valueOf(ww));
//                    Log.d("H", String.valueOf(hh));
//                    Log.d("TT", "x" + x + "y" + y);
                    //Snackbar.make(getRootView(), "TouchX" + x + "TouchY" + y, Snackbar.LENGTH_SHORT).show();
                        point++;
//                    onRandom(); // get new position
//                    invalidate(); // clear view

                    return true;
                }
                return false;
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

    public void onRandom(){
         radius = r.nextInt(120 - 50) + 50;
         ww = r.nextFloat() * (maxWidth - minWidth) + minWidth;
         hh = r.nextFloat() * ((maxHeight - 500) - minHeight) + minHeight;
    }
    public void getDeviceSize(){
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        maxWidth = metrics.widthPixels;
        maxHeight = metrics.heightPixels;
    }
    public int getPoint(){
        return point;
    }
    public void rePoint(){
        this.point = 0;
    }
}
