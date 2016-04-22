package com.example.panupong.exercise.Struct_Func;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.panupong.exercise.R;
import com.example.panupong.exercise.Struct_Func.Product;
import com.example.panupong.exercise.Struct_Func.TaxSystem;

/**
 * Created by Panupong on 4/21/2016.
 */
public class class_func extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_func);

        TextView tv1 = (TextView) findViewById(R.id.textView1);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView3);

        Product pd = new Product("note",200);
        TaxSystem ts = new TaxSystem(66);

        //ts.Calctax(pd);
        tv1.setText("Name - " + pd.getName());
        tv2.setText("price - "+ pd.getPrice());
        tv3.setText("taxPercent - "+ts.getTaxPercentage());


        Log.d("Product","Name - "+ pd.getName());
        Log.d("Product","price - "+ pd.getPrice());
        Log.d("Tax","taxPercent - "+ts.getTaxPercentage());
    }
}
