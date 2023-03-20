import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Hammurabi {
    Scanner scanner = new Scanner(System.in); //scanner object for taking user input

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.

        int price; //current cost of land
        int population = 100; //current population size
        int bushels = 2800; //current bushels of grain owned
        int acresOwned = 1000; //current acres of land owned
        int bushelsFedToPeople = 0;
        int howManyPeopleStarved = 0;
        int bushelsUsedAsSeed = 0;
        int newCostOfLand = 19;
        int yearsLeft = 10;
        int immigrants = 0;
        int deaths = 0;
        boolean uprising = false;
        String status = "---------------------------------------------------\nYour current population is " + population + "\nYou own " + acresOwned + " acres of land.\nYou own " + bushels + " grain reserves.\nThe current value of land is " + newCostOfLand + " bushels/acre\n---------------------------------------------------\n";
        // statements go after the declarations

        System.out.println("Welcome, great Hammurabi! You have been chosen to govern the people " + "for the next " + yearsLeft + " years.\nBefore you begin your reign please consider the following: \n" + "Your starting population is " + population + "\nYour starting land is " + acresOwned + " acres.\nYour starting" + " grain reserves are " + bushels + " bushels.\nThe current value of land is " + newCostOfLand + " bushels/acre");

        while (uprising == false && yearsLeft > 0) { //game continues as long as there's no uprising
            System.out.println("Current turn " + (11 - yearsLeft));
            int acresToBuy = askHowManyAcresToBuy(newCostOfLand, bushels);
            System.out.println(status);
            if (acresToBuy == 0) {
                int acresToSell = askHowManyAcresToSell(acresOwned);
                System.out.println(status);
            }
            int grainToFeed = askHowMuchGrainToFeed(bushels);
            System.out.println(status);
            int acresToPlant = askHowManyAcresToPlant(acresOwned, population, bushels);
            System.out.println(status);

            uprising = uprising(population,howManyPeopleStarved);
            population = population - plagueDeaths(population);
            population = population - starvationDeaths(population,bushelsFedToPeople);
            population = population + immigrants(population,acresOwned,bushels);
            bushels = bushels + harvest(bushelsUsedAsSeed);
            bushels = bushels - grainEatenByRats(bushels);
            newCostOfLand = newCostOfLand();
            yearsLeft--;
        }

    }

    //THE FOLLOWING METHODS ARE IN SEQUENCE FROM INSTRUCTIONS

    /**
     * METHODS THAT TAKE USER INPUT:
     **/

    public int getNumber(String message) {
        while (true) {
            System.out.print(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }

    public int askHowManyAcresToBuy(int price, int bushels) {
        while (true) {
            int acresToBuy = getNumber("How many acres would you like to buy? ");
            if (acresToBuy * price <= price * bushels) {
                System.out.println("You purchased " + acresToBuy);
                return acresToBuy;
            }
        }
    }


    public int askHowManyAcresToSell(int acresOwned) {
        while (true) {
            int acresToSell = getNumber("How many acres would you like to sell? ");
            if (acresToSell <= acresOwned) {
                System.out.println("You sold " + acresToSell + " acres.");
                return acresToSell;
            }
            System.out.println("You can't sell what you don't own.");
        }
    }

    public int askHowMuchGrainToFeed(int bushels) {
        while (true) {
            int grainToFeed = getNumber("How much food will you give the peasants?");
            if (grainToFeed <= bushels) {
                return grainToFeed;
            }
            System.out.println("You can't give what you don't have.");
        }
    }

    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        while (true) {
            int acresToPlant = getNumber("How many acres do you wish to plant?");
            if (acresToPlant < population * 10 && acresToPlant / 2 < bushels && acresToPlant < acresOwned) {
                return acresToPlant;
            }
            System.out.println("My lord, you don't have the resources to do that right now...");
        }
    }

    /**
     * NON-USER INPUT METHODS:
     **/

    public int plagueDeaths(int population) {
        int previousPopulation = population; //stores the previousPopulation before the if statement so i can compare original value to modified value
        if (Math.random() * 100 <= 15) { //rolls to see if plague will occur
            population = population / 2; //if plague occurs then reduce population by half
        }
        int deaths = previousPopulation - population;
        return deaths;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        int starvationDeaths = 0;
        int bushelsRequired = population * 20; //population * 40 returns total food required
        int bushelsDeficit = (bushelsRequired - bushelsFedToPeople); //bushelsRequired - bushelsFed = busheslDeficit
        if (bushelsFedToPeople < bushelsRequired) {
            if (bushelsDeficit / 20 % 2 != 0) {
                starvationDeaths = bushelsDeficit / 20;
            } else {
                starvationDeaths = bushelsDeficit / 20 + 1;
            }
        }
        System.out.println("My lord, " + starvationDeaths + " people have died due to starvation!");
        return starvationDeaths;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        System.out.println("This is the end, my lord. They people have revolted and they ask for your head!");
        return howManyPeopleStarved > (0.45 * population); //checks if people who died of starvation exceeds 45% of the population

    }

    public int immigrants(int population, int acres, int bushels) {
        int populationGrowth = (20 * acres + bushels) / (100 * population) + 1;
        System.out.println("Great news, my lord! " + populationGrowth + " more people have come to live in your kingdom!");

        return populationGrowth;
    }

    public int harvest(int bushelsUsedAsSeed) {
        int harvestValue = ((int) (Math.random() * 6) + 1) * bushelsUsedAsSeed; // calculates harvest value by applying the random multiplier
        System.out.println("My lord, thanks to your guidance we have harvested " + harvestValue + " bushels of grain.");
        return harvestValue;
    }

    public int grainEatenByRats(int bushels) {
        int eatenRand = (int) (Math.random() * 3) + 1; //random num from 1-3
        int eatenPercent = (eatenRand * 10) / 100; //converts eaten amount to a percent;
        int ratRand = (int) (Math.random() * 10) + 1; //random num from 1-11
        int amountEaten = (int) Math.ceil(bushels - eatenPercent);
        if (ratRand > 0 && ratRand <= 4) {
            System.out.println("Oh no, my lord! A plague of rats has eaten " + amountEaten + " bushels of grain from our reserves!");
            return amountEaten;
        } else return 0;
    }


    public int newCostOfLand() {
        Random rand = new Random();
        int costOfLand = rand.nextInt(7) + 17; //* (max - min) + min with max being exclusive and min inclusive
        //24 - 17 = 7    17
        return costOfLand;
    }
}




