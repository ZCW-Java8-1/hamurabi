import java.sql.SQLOutput;
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
        // statements go after the declarations

        System.out.println("Welcome, great Hammurabi! You have been chosen to govern the people " + "for the next " + yearsLeft + " years.\nBefore you begin your reign please consider the following: " + "Your starting population is " + population + "\nYour starting land is " + acresOwned + " acres.\nYour starting" + " grain reserves are " + bushels + " bushels.\nThe current value of land is " + newCostOfLand + " bushels/acre");



    }

    //THE FOLLOWING METHODS ARE IN SEQUENCE FROM INSTRUCTIONS

    /**
     * METHODS THAT TAKE USER INPUT:
     **/
    public int askHowManyAcresToBuy(int price, int bushels) {
        System.out.println("How maybe acres would you like to buy this round? Please choose a value between 0 and " + bushels / price);
        int acresToBuy = scanner.nextInt();
        //if (acresToBuy * price <= price * bushels) //use this condition outside of the method
        return acresToBuy;
    }

    public int askHowManyAcresToSell(int acresOwned) {
        int acresToSell = scanner.nextInt();
        //if(acresToSell <= acresOwned) //use this condition outside of the method
        return acresToSell;
    }

    int askHowMuchGrainToFeed(int bushels) {
        int grainToFeed = scanner.nextInt();
        return grainToFeed;
    }

    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        int acresToPlant = scanner.nextInt();
        return acresToPlant;
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
        int originalPopulation = population;
        int bushelsRequired = originalPopulation * 40;
        if (bushelsFedToPeople < bushelsRequired) {
            starvationDeaths = originalPopulation - (bushelsRequired - (bushelsFedToPeople / 40)); //calculate how many people will die and update the population count
        }
        return starvationDeaths;
    }

    public boolean uprising(int population, int howManyPeopleStarved) {
        return howManyPeopleStarved > (0.45 * population); //checks if people who died of starvation exceeds 45% of the population
    }

    public int immigrants(int population, int acres, int bushels) {
        int populationGrowth = (20 * acres + bushels) / (100*population)+1;

        return populationGrowth;
    }

    public int harvest(int acres, int bushelsUsedAsSeed) {
        int harvestValue = ((int) Math.random() * 6 + 1) * bushelsUsedAsSeed; // calculates harvest value by applying the random multiplier
        return harvestValue;
    }

    public int grainEatenByRats(int bushels, int chanceOfPlague) {
        int originalBushelCount = bushels;
        int plagueChance = (int) Math.random() * 41;
        int amountEaten = (int) Math.random() * 21 + 10;

        return originalBushelCount % bushels * amountEaten / 100;
    }

    public int newCostOfLand(int costOfLand) {
        costOfLand = (int) Math.random() * 7 + 17;

        return costOfLand;
    }
}




