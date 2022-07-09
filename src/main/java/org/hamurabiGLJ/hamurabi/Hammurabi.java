package org.hamurabiGLJ.hamurabi;

import java.util.*;

public class Hammurabi {
    Random rand = new Random();  // this is an instance variable
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declations
    }

    int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
    int askHowManyAcresToBuy(int price, int bushels) {return 0;}
    //other methods go here
    int askHowManyAcresToSell(int acresOwned) {return 0;}

    int askHowMuchGrainToFeedPeople(int bushels) {return 0;}

    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {return 0;};

    int plagueDeaths(int population) {return 0;}

    int starvationDeaths(int population, int bushelsFedToPeople) {return 0;}

    boolean uprising(int population, int howManyPeopleStarved) {return false;}

    int immigrants(int population, int acresOwned, int grainInStorage) {return 0;}

    int harvest(int acres, int bushelsUsedAsSeed) {return 0;}

    int grainEatenByRats(int bushels) {return 0;}

    int newCostOfLand() {return 0;}
}
