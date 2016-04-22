package com.example.panupong.exercise.Struct_Func;

/**
 * Created by Panupong on 4/21/2016.
 */
public class Product {
    private String name;
    private long price;
    private long tax;

    public Product(String name,long price,long tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }
    public Product(String name,long price){
        this.name = name;
        this.price = price;
    }


    public String getName(){
        return name;
    }
    public long getPrice(){
        return price;
    }
    public long getTax(){
        return tax;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setTax(int tax){
        this.tax = tax;
    }


    public String print(){
        return name + String.valueOf(price);
    }



}
