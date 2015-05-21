package com.gleb.horseRaces.assets;

import java.util.Random;

/**
 * Created by Gleb Belkin (gleb.belkin@outlook.com) on 20.05.2015.
 */
public enum HorseName {
    ABACCUS("Abaccus"),
    BADGER("Badger"),
    CAESER("Caeser"),
    DALLAS("Dallas"),
    ECLIPSE("Eclipse");


    //    public static final List<HorseName> VALUES = ;
    public static final Random RANDOM = new Random();
    public static final int SIZE = values().length;

    private final String name;

    public static String randomName() {
//todo array is created every time after the values() call, move it to the static field
        return values()[RANDOM.nextInt(SIZE)].name;
    }

    HorseName(String name) {
        this.name = name;
    }
}
