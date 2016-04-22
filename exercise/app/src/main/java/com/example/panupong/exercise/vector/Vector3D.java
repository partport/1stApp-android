package com.example.panupong.exercise.vector;

import android.util.Log;

/**
 * Created by Panupong on 4/21/2016.
 */
public class Vector3D {
    private double x;
    private double y;
    private double z;
    private double h;


    public void addVector(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void setX(double x){
        this.x = x;
    }
    public void  setY(double y){
        this.y = y;
    }
    public void setZ(double z){
        this.z = z;
    }
    public void  Translation(Vector3D vt,int distance,String axis){
        switch (axis.toUpperCase()){
            case "X":
                this.x = vt.x +distance;
                this.y = vt.y;
                this.z = vt.z;
                break;
            case "Y":
                this.x = vt.x;
                this.y = vt.y+distance;
                this.z = vt.z;
                break;
            case "Z":
                this.x = vt.x;
                this.y = vt.y;
                this.z = vt.z+distance;
                break;
        }
    }
    public void Rotation(Vector3D vt,double angle,String axis){
        double coX,coY,coZ;
        coX = vt.x;
        coY = vt.y;
        coZ = vt.z;

        Log.d("##1",String.valueOf(vt.y));
        double rCos,rSin;
        rCos = Math.round(Math.cos(Math.toRadians(angle)));
        rSin = Math.round(Math.sin(Math.toRadians(angle)));
        Log.d("COS",String.valueOf(rCos));
        Log.d("SIN",String.valueOf(rSin));
        if(axis == "X"){
            setX(vt.x);
            setY((coY * rCos) - (coZ * rSin));
            setZ((coY* rSin) + (coZ * rCos));
        }else if(axis == "Y"){
            setY(vt.y);
            setX((coX*rCos)+(coZ*rSin));
            setZ(((-coX) * rSin) + (coZ * rCos));
        }else if(axis == "Z"){
            setZ(vt.z);
            setX((coX*rCos) - (coY*rSin));
            setY((coX*rSin) + (coY*rCos));
        }
    }

    public String showCoordinates(){
        return "X = " + x +"\n" +
                "Y = " + y + "\n"+
                "Z = " + z ;
    }
}
