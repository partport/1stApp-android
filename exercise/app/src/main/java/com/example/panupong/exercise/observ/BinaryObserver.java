package com.example.panupong.exercise.observ;

import android.util.Log;

/**
 * Created by Panupong on 4/21/2016.
 */
public class BinaryObserver extends Observer {
    public  BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        Log.d("--", "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }

}
