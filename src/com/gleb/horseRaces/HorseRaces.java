package com.gleb.horseRaces;

import com.gleb.horseRaces.assets.Horse;
import com.gleb.horseRaces.assets.HorseName;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Gleb Belkin (gleb.belkin@outlook.com) on 20.05.2015.
 */
public class HorseRaces {
    private static final int horsesNumber = 12;
    private static Vector<Horse> stable = new Vector<Horse>(horsesNumber);
    private static boolean weHaveWinner = false;
    private static final int totalDistance = 70;
    public static Scanner userInput = new Scanner(System.in);

    private static final int selectedHorse = 5;

    public static void main(String[] args) {
        createHorses();
        displayHorses();
        int bet = userInput.nextInt();
        System.out.println(bet);
        /*
        while (!weHaveWinner) {
            for (Iterator<Horse> iterator = stable.iterator(); iterator.hasNext(); ) {
                Horse next = iterator.next();
                next.addTime(1);
                if (next.getDistanceCovered() > totalDistance) {
                    weHaveWinner = true;
                    break;
                }
            }
        }*/
    }

    private static void displayHorses() {
        for (int i = 0; i < stable.size(); i++) {
            System.out.printf("%2$s. %1$s\n", stable.get(i).getName(), i);
        }

    }


    private static void createHorses() {
        for (int i = 0; i < horsesNumber; i++) {
            stable.add(new Horse(HorseName.randomName()));
        }
    }
}
