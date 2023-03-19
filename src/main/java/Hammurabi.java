import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Hammurabi {

    int plagueDeaths = 0;
    int starvationDeaths = 0;
    boolean uprising = false;
    int immigrants = 0;
    int harvest = 0;
    int grainEatenByRats = 0;
    int newCostOfLand = 0;
    int yearsLeft = 10;
    int population = 100;
    int acres = 1000;
    int bushels = 2800;
    boolean isAlive = true;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // required in every Java program
        new Hammurabi().playGame();
    }

    void playGame() {
        // declare local variables here: grain, population, etc.
        // statements go after the declarations
        System.out.println("Welcome, great Hammurabi! You have been chosen to govern the people " + "for the next " + yearsLeft + " years.\nBefore you begin your reign please consider the following: " + "Your starting population is " + population + "\nYour starting land is " + acres + " acres.\nYour starting" + " grain reserves are " + bushels + " bushels.\nThe current value of land is " + newCostOfLand + " bushels/acre");


        int deaths = plagueDeaths(this.population);

//       while (isAlive) {
//            if (populationThisTurn < 45 % of populace){
//                isAlive = false;
//                break;
//            }
//        }
        System.out.println(deaths);
    }


    public int plagueDeaths(int population) {
        if(Math.random() * 100 <=15){
            this.population = population / 2;
        }
        return population - this.population;
    }



    public int starvationDeaths(int population, int bushelsFedToPeople) {

        return 0;
    }

    public int uprising(int i) {

        return 0;
    }

    public int immigrants(int i) {

        return 0;
    }

    public int harvest(int i) {

        return 0;
    }

    public int grainEatenByRats(int i) {

        return 0;
    }

    public int newCostOfLand(int i) {

        return 0;
    }


}



