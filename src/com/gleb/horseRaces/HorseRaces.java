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
    private static int currentTimeMinutes = 0;
    private static final float timeQuantMinutes = 5;
    private static Horse winner;

    public static void main(String[] args) {
        createHorses();
        displayHorses();

        boolean correctBet = false;
        int betIndex = 0;
        while (!correctBet)
        {
            betIndex = userInput.nextInt();
            if (betIndex < 0 || betIndex > horsesNumber){
                System.out.println("Your bet is out of range, please select another one.");
            } else {
                correctBet = true;
            }
        }
        //vector is zero-based
        betIndex--;
        Horse bet = stable.get(betIndex);
        System.out.println("All bets are off!\n");
        while (!weHaveWinner) {
            Iterator<Horse> itr = stable.iterator();
            currentTimeMinutes += timeQuantMinutes;
            System.out.printf("-------time: %1$s\n", currentTimeMinutes);
            while (itr.hasNext()) {
                Horse currentHorse = itr.next();
                currentHorse.addDistanceByMinutes(timeQuantMinutes);
                System.out.printf("\t %3$s %1$s: %2$s km\n", currentHorse.getName(), currentHorse.getDistanceCovered(), currentHorse.getNumber());
                if (currentHorse.getDistanceCovered() > totalDistance) {
                    winner = currentHorse;
                    weHaveWinner = true;
                    //uncomment 'break' to avoid redundant calculations, commented for the all-participants output
                    //break;
                }
            }
        }
        System.out.printf("\nWinner: %1$s (N%2$s), your bet is %3$s (%4$s)\n", winner.getName(), winner.getNumber(), bet.getName(), bet.getNumber());
        if (winner.getNumber() == bet.getNumber()) {
            System.out.println("Congratulations, you win!");
        } else {
            System.out.println("Sorry man, you lose. Maybe next time...");
        }
    }

    private static void displayHorses() {
        for (int i = 0; i < stable.size(); i++) {
            System.out.printf("%2$s. %1$s\n\t min speed: [%3$s kmph]\n\t max speed: [%4$s kmph]\n", stable.get(i).getName(), stable.get(i).getNumber(), stable.get(i).getMinSpeed(), stable.get(i).getMaxSpeed());
        }

    }


    private static void createHorses() {
        for (int i = 0; i < horsesNumber; i++) {
            Horse horse = new Horse(HorseName.randomName());
            horse.giveNumber(i + 1);
            stable.add(horse);
        }
    }
}
