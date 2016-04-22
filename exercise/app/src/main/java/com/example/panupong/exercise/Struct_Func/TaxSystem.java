package com.example.panupong.exercise.Struct_Func;

/**
 * Created by Panupong on 4/21/2016.
 */
public class TaxSystem {
    private float taxPercentage;

    public TaxSystem(float taxPercentage){
        this.taxPercentage = taxPercentage;
    }
    public TaxSystem(){
        super();
    }

    public float getTaxPercentage(){
        return taxPercentage;
    }
    public void setTaxPersentage(float taxPercentage){
        this.taxPercentage = taxPercentage;
    }
    public void Calctax (Product product){

    }
}
