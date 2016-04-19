package com.example.panupong.firstapp;

import android.app.Activity;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * Created by Panupong on 4/11/2016.
 */
public class page_2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        final Employee emp = new Employee("Note",18,Employee.GenderEnum.Unknow);

        EditText txtName = (EditText)findViewById(R.id.et_name);
        final EditText txtAge = (EditText) findViewById(R.id.et_age);
        RadioButton rdoUnknown = (RadioButton) findViewById(R.id.rdo_unknown);
        RadioButton rdoMale = (RadioButton) findViewById(R.id.rdo_male);
        RadioButton rdoFemale = (RadioButton) findViewById(R.id.rdo_female);
        Button btnPlus = (Button) findViewById(R.id.btn_age_plus);
        Button btnMinus = (Button) findViewById(R.id.btn_age_minus);
        Button btnSave = (Button) findViewById(R.id.btn_save);

        txtName.setText(emp.getName());
        txtAge.setText(String.valueOf(emp.getAge()));

        switch (emp.getGender()){
            case Unknow: rdoUnknown.setChecked(true); break;
            case Male: rdoMale.setChecked(true); break;
            case Female: rdoFemale.setChecked(true); break;
        }

        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                emp.setName(s.toString());
            }
        });
        txtAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                emp.setAge(s.length() > 0 ? Integer.parseInt(s.toString()):0);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emp.setAge(emp.getAge()+1);
                txtAge.setText(String.valueOf(emp.getAge()));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emp.setAge(emp.getAge()-1);
                if(emp.getAge() <0){
                    txtAge.setText("0");
                }else{
                txtAge.setText(String.valueOf(emp.getAge()));
                }
            }
        });
        rdoUnknown.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    emp.setGender(Employee.GenderEnum.Unknow);
                }
            }
        });
        rdoMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    emp.setGender(Employee.GenderEnum.Male);
                }
            }
        });
        rdoFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    emp.setGender(Employee.GenderEnum.Female);
                }
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 new AlertDialog.Builder(page_2.this)
                         .setTitle("EMPLOYEE")
                         .setMessage(emp.toString())
                         .create()
                         .show();
            }
        });
    }
}
