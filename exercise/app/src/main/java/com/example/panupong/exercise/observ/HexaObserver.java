package com.example.panupong.exercise.observ;

import android.util.Log;

/**
 * Created by Panupong on 4/21/2016.
 */
public class HexaObserver extends Observer {
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        Log.d("--", "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase()  );
    }
}
