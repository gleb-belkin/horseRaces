package com.gleb.horseRaces.assets;

import java.util.Random;

/**
 * Author: Gleb Belkin (gleb.belkin@outlook.com).
 */
public class Horse {
    private final String name;
    private final int minSpeed;
    private final int maxSpeed;
    private float timeCompletedHours = 0;
    private static final Random rnd = new Random();
    private float distanceCovered = 0;
    private int number;

    public Horse(String name) {
        this.name = name;
        int averageSpeed = 60;
        minSpeed = averageSpeed - rnd.nextInt(5);
        maxSpeed = averageSpeed + rnd.nextInt(5);
    }

    public void addDistanceByHours(float hours) {
        timeCompletedHours += hours;
        int lapSpeed = minSpeed + (maxSpeed - minSpeed) * rnd.nextInt(10) / 10;
        distanceCovered = distanceCovered + lapSpeed * hours;
    }

    public void addDistanceByMinutes(float minutes) {
        addDistanceByHours(minutes / 60);
    }

    public float getDistanceCovered() {
        return distanceCovered;
    }

    public String getName() {
        return name;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void giveNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
