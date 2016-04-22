package com.example.panupong.exercise.observ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Panupong on 4/21/2016.
 */
public class Subject {
    private List<Observer> ob = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return state;
    }
    public void addState(int state){
        this.state = state;
        notifyAllObservers();
    }
    public void notifyAllObservers(){
        for (Observer observer : ob) {
            observer.update();
        }
    }

    public void attach(Observer observer){
        ob.add(observer);
    }

}

