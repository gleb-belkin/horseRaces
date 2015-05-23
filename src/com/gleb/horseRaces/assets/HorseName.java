package com.gleb.horseRaces.assets;

import java.util.Random;

/**
 * Author: Gleb Belkin (gleb.belkin@outlook.com).
 */
public enum HorseName {
    ABACCUS("Abaccus"),
    BADGER("Badger"),
    CAESER("Caeser"),
    DALLAS("Dallas"),
    ECLIPSE("Eclipse");

    //    public static final List<HorseName> VALUES = ;
    private static final Random RANDOM = new Random();
    private static final int SIZE = values().length;

    private final String name;

    public static String randomName() {
        //todo array is created every time after the values() call, move it to the static field
        return values()[RANDOM.nextInt(SIZE)].name;
    }

    HorseName(String name) {
        this.name = name;
    }
}
