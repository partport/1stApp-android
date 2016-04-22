package com.example.panupong.exercise.observ;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.panupong.exercise.R;
import com.example.panupong.exercise.observ.BinaryObserver;
import com.example.panupong.exercise.observ.HexaObserver;
import com.example.panupong.exercise.observ.OctalObserver;
import com.example.panupong.exercise.observ.Subject;

/**
 * Created by Panupong on 4/21/2016.
 */
public class ObserverPattern extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.observer);
        final Subject subject = new Subject();
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        final EditText num = (EditText) findViewById(R.id.num);
        Button btn = (Button)findViewById(R.id.btn_ok);
        tv = (TextView) findViewById(R.id.tshow);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject.addState(Integer.valueOf(num.getText().toString()));

            }
        });

        Log.d("###","First stat change 15");
        subject.addState(15);
        Log.d("###","Second stat change 10");
        subject.addState(10);
        Log.d("###","Second stat change 20");
        subject.addState(20);

    }

}
