package com.example.panupong.firstapp;

/**
 * Created by Panupong on 4/11/2016.
 */
public class Employee {
    private String name;
    private int age;
    private GenderEnum gender;

    public enum GenderEnum {Unknow,Male,Female}

    public Employee(String name,int age,GenderEnum gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public GenderEnum getGender(){
        return gender;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(GenderEnum gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name = " + name + "\n" +
                "age = " + age + "\n" +
                "gender = " + gender ;
    }

}
