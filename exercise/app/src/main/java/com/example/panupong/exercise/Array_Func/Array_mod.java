package com.example.panupong.exercise.Array_Func;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.example.panupong.exercise.R;

import java.util.Random;

/**
 * Created by Panupong on 4/21/2016.
 */
public class Array_mod extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array);
        int round = 10;
        int[] data_old = new int[round];
        int[] data_new;
        String lsNew ="";
        String lsOld ="";

        Random ran = new Random();
        for (int j=1;j<round;j++) {
            data_old[j] = ran.nextInt(100-1)+1;
        }

        TextView tv1 = (TextView)findViewById(R.id.data1);
        TextView tv2 = (TextView)findViewById(R.id.data2);

        for(int k=0 ; k<data_old.length;k++){
            Log.d("--",String.valueOf(data_old[k]));
            lsOld += String.valueOf(data_old[k]) + ",";
        }
        tv1.setText(lsOld);


        data_new = func(data_old);
        for(int k=0 ; k<data_new.length;k++){
            Log.d("--",String.valueOf(data_new[k]));
            lsNew += String.valueOf(data_new[k]) + ",";
        }
        tv2.setText(lsNew);


    }


    public int[] func (int[] number){

        for(int i =0 ;i < number.length;i++){
            if((number[i] % 10) == 0 ){
                number[i] =0;
            }else if((number[i] %3) ==0){
                number[i] = number[i]*3;
            }else if((number[i]) %9 == 0){
                number[i] = number[i]*9;
            }
        }
        return number;

    }
}
