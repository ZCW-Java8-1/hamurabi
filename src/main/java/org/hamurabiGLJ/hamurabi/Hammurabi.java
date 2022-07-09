package org.hamurabiGLJ.hamurabi;

import java.util.*;

public class Hammurabi {
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);
    private int land;


    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        Integer grain = 2800;
        Integer population = 100;
        Integer land = 1000;
        Integer landValue = 19;

        // statements go after the declarations
        System.out.println(askHowManyAcresToSell(123));
    }

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }

    int askHowManyAcresToBuy(int price) {
        return 0;
    }

    //other methods go here
    int askHowManyAcresToSell(int acresOwned) {
        int acresToSell = getNumber("How many acres of land would you like to sell?\n");
        while (acresToSell > acresOwned) {
            System.out.println("O Hammurabi, but you only have " + land + " acres of land!\n");
            acresToSell = getNumber("How many acres of land would you like to sell?\n");
        }
        return acresToSell;
    }

    int askHowMuchGrainToFeedPeople(int bushels) {
        return 0;
    }

    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        int acresToPlant = getNumber("How many acres");
        return 0;
    }

    int plagueDeaths(int population) {
        return 0;
    }

    int starvationDeaths(int population, int bushelsFedToPeople) {
        return 0;
    }

    boolean uprising(int population, int howManyPeopleStarved) {
        return false;
    }

    int immigrants(int population, int acresOwned, int grainInStorage) {
        return 0;
    }

    int harvest(int acres, int bushelsUsedAsSeed) {
        return 0;
    }

    int grainEatenByRats(int bushels) {
        return 0;
    }

    int newCostOfLand() {
        return 0;
    }
}
