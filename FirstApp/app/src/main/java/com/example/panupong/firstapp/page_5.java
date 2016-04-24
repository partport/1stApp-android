package com.example.panupong.firstapp;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by SystemPause on 4/22/2016.
 */
public class page_5 extends AppCompatActivity implements SensorEventListener{

    int count =0;
    private SensorManager mySensorManager;
    /* Here we store the current values of acceleration, one for each axis */
    private float xAccel;
    private float yAccel;
    private float zAccel;

    /* And here the previous ones */
    private float xPreviousAccel;
    private float yPreviousAccel;
    private float zPreviousAccel;

    /* Used to suppress the first shaking */
    private boolean firstUpdate = true;

    /*What acceleration difference would we assume as a rapid movement? */
    private final float shakeThreshold = 7.7f;

    /* Has a shaking motion been started (one direction) */
    private boolean shakeInitiated = false;
    TextView tv_shake;
    ProgressBar mProgress;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
        mySensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE); // (1)
        mySensorManager.registerListener(this, mySensorManager
                        .getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL); // (2)
        tv_shake = (TextView) findViewById(R.id.shake);
        mProgress = (ProgressBar) findViewById(R.id.pBarShake);
        tv_shake.setText("");
    }

    @Override
    public void onSensorChanged(SensorEvent se) {

        updateAccelParameters(se.values[0], se.values[1], se.values[2]);   // (1)
        if ((!shakeInitiated) && isAccelerationChanged()) {                                      // (2)
            shakeInitiated = true;
        } else if ((shakeInitiated) && isAccelerationChanged()) {                              // (3)
            executeShakeAction();
        } else if ((shakeInitiated) && (!isAccelerationChanged())) {                           // (4)
            shakeInitiated = false;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void updateAccelParameters(float xNewAccel, float yNewAccel,
                                       float zNewAccel) {
                /* we have to suppress the first change of acceleration, it results from first values being initialized with 0 */
        if (firstUpdate) {
            xPreviousAccel = xNewAccel;
            yPreviousAccel = yNewAccel;
            zPreviousAccel = zNewAccel;
            firstUpdate = false;
        } else {
            xPreviousAccel = xAccel;
            yPreviousAccel = yAccel;
            zPreviousAccel = zAccel;
        }
        xAccel = xNewAccel;
        yAccel = yNewAccel;
        zAccel = zNewAccel;
    }
    private boolean isAccelerationChanged() {
        float deltaX = Math.abs(xPreviousAccel - xAccel);
        float deltaY = Math.abs(yPreviousAccel - yAccel);
        float deltaZ = Math.abs(zPreviousAccel - zAccel);
        return (deltaX > shakeThreshold && deltaY > shakeThreshold)
                || (deltaX > shakeThreshold && deltaZ > shakeThreshold)
                || (deltaY > shakeThreshold && deltaZ > shakeThreshold);
    }
    private void executeShakeAction() {

        count++;

        Log.d("SHAKE","SHAKING::"+count);
        tv_shake.setText(count+"/60");

        handler.post(new Runnable() {
            @Override
            public void run() {
                    mProgress.setProgress(count);
                if(count>=60){
                    count =0;
                    finish();

                }
            }
        });


    }

}
