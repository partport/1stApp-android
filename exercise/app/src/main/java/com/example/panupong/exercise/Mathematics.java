package com.example.panupong.exercise;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.panupong.exercise.vector.Vector3D;

/**
 * Created by Panupong on 4/21/2016.
 */
public class Mathematics extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vector);
        Button btn1 = (Button) findViewById(R.id.btn_tran);
        Button btn2 = (Button) findViewById(R.id.btn_rotat);
        TextView tv1 = (TextView) findViewById(R.id.vc_tv1);
        final TextView tv2 = (TextView) findViewById(R.id.vc_tv2);
        final EditText ds = (EditText) findViewById(R.id.distance);
        final EditText dg = (EditText) findViewById(R.id.degree);
        final RadioButton axisX = (RadioButton) findViewById(R.id.rx);
        final RadioButton axisY = (RadioButton) findViewById(R.id.ry);
        final RadioButton axisZ = (RadioButton) findViewById(R.id.rz);




        final Vector3D vt = new Vector3D();

        vt.addVector(5,6,7);
        tv1.setText(vt.showCoordinates());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(axisX.isChecked()) {
                    vt.Translation(vt, Integer.valueOf(ds.getText().toString()), "X");
                    tv2.setText(vt.showCoordinates());
                }else if(axisY.isChecked()){
                    vt.Translation(vt, Integer.valueOf(ds.getText().toString()), "Y");
                    tv2.setText(vt.showCoordinates());
                }else if(axisZ.isChecked()){
                    vt.Translation(vt, Integer.valueOf(ds.getText().toString()), "Z");
                    tv2.setText(vt.showCoordinates());
                }else  {
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(axisX.isChecked()) {
                    vt.Rotation(vt,Integer.valueOf(dg.getText().toString()),"X");
                    tv2.setText(vt.showCoordinates());
                }else if(axisY.isChecked()){
                    vt.Rotation(vt,Integer.valueOf(dg.getText().toString()),"Y");
                    tv2.setText(vt.showCoordinates());
                }else if(axisZ.isChecked()){
                    vt.Rotation(vt,Integer.valueOf(dg.getText().toString()),"Z");
                    tv2.setText(vt.showCoordinates());
                }else  {
                }
            }
        });

    }
}
