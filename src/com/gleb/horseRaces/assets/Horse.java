package com.gleb.horseRaces.assets;

import java.util.Random;

/**
 * Created by Gleb Belkin (gleb.belkin@outlook.com) on 20.05.2015.
 */
public class Horse {
    private final int averageSpeed = 10;
    private final String name;
    private int minSpeed;
    private int maxSpeed;
    private int timeCompleted =0;

    public Horse(String name) {
        this.name = name;
        Random rnd = new Random();
        minSpeed = averageSpeed - rnd.nextInt(5);
        maxSpeed = averageSpeed + rnd.nextInt(5);
    }

    public void addTime(int hours){
        timeCompleted+=hours;
    }

    public int getDistanceCovered(){
        return timeCompleted*minSpeed;
    }


    public String getName() {
        return name;
    }
}
