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
        if (Math.random() * 100 <= 15) {
            this.population = population / 2;
        }
        return population - this.population;
    }

    public int starvationDeaths(int population, int bushelsFedToPeople) {
        if (bushelsFedToPeople < population * 20) {
            System.out.println(this.population - this.bushelsFedToPeople + " people have died due to starvation!");
            this.population -= this.population - this.bushelsFedToPeople; //calculate how many people will die and update the population count

            return population;
        }

        public boolean uprising (this.population,int howManyPeopleStarved){
            if ()

                return 0;
        }

        public int immigrants ( int population, int acres, int bushels){
            if (starvationDeaths == 0) {
                this.population += this.acres * this.bushels + bushels / (100 * this.population + 1);
            }

            return 0;
        }

        public int harvest ( int acres, int bushelsUsedAsSeed, int harvestModifier){ //total harvest =
            if ()
                int harvestValue = (int) Math.random() * 6 + 1; //
            return harvestValue;
        }

        public int grainEatenByRats ( int i){

            return 0;
        }

        public int newCostOfLand ( int i){

            return 0;
        }


    }
}



