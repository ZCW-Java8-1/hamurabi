package hammurabi;

import java.util.Random;
import java.util.Scanner;

public class Console {
    Scanner scan = new Scanner(System.in); //Create a scanner object
    Random rand = new Random();
    int currentYear = 1;
    int acres = 1000;
    int bushelsGrain = 2800;
    int population = 100;
    int landValue = 19;
    int price = 0;

    public void playGame() { // call methods in loop here?
        summary();
        askHowManyAcresToBuy();
        askHowManyAcresToSell();
        askHowMuchGrainToFeedPeople();
    }


    public void summary() {
        System.out.println("O great Hammurabi!\n" +
                "You are in year " + currentYear + " of your ten year rule.\n" +
                //"In the previous year 0 people starved to death.\n" +
                //"In the previous year 5 people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushelsGrain + " bushels at 3 bushels per acre.\n" +
                //"Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                "The city owns " + acres + " acres of land.\n"); //delete once next line is needed
        //"Land is currently worth "+landValue+" bushels per acre.");
    }

    public void askHowManyAcresToBuy() {
        System.out.println("How many acres of land do you wish to buy?");

        while (true) {
            //Scanner input = new Scanner(System.in);
            int input = scan.nextInt();
            if (input <= acres) {
                acres += input;
                System.out.println(askHowMuchGrainToFeedPeople());
                break;
            } else if (input == 0) {
                askHowManyAcresToSell();
            }
        }
    }

    public void askHowManyAcresToSell() {
        System.out.println("How many acres of land do you wish to sell?");
        while (true) {
            //Scanner input = new Scanner(System.in);
            int input = scan.nextInt();
            if (input <= acres) {
                System.out.println("You now have "+(acres -= input)+" acres of land.");
                //break;
            } else if (input == 0) {
                askHowMuchGrainToFeedPeople();
            }

        }
    }
    public Object askHowMuchGrainToFeedPeople() {
        System.out.println("How much grain would you like to feed people?");
        return null;
    }
}

