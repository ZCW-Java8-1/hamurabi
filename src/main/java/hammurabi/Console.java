package hammurabi;

import java.util.InputMismatchException;
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

        while (true) {
            int num = getNumber("How many acres of land do you wish to buy? \n");
            //if (num < 0) continue;
            if (num == 0) {
                askHowManyAcresToSell();
                break;
            } else if (num * landValue <= bushelsGrain) {
                acres += num;
                bushelsGrain -= num * landValue;
                break;
            } else {
                System.out.println("O no! You do not have enough grain for that!");
            }
        }

    }

    public void askHowManyAcresToSell() {

        while (true) {
            int num = getNumber("How many acres of land do you wish to sell? \n");
            if (num > acres) {
                System.out.println("O no! You do not have enough land for that!");
            } else {
                acres -= num;
                bushelsGrain += num * landValue;
                break;
            }
        }

    }

    public void askHowMuchGrainToFeedPeople() {
        while (true) {
            int num = getNumber("How much grain would you like to feed people? \n");
            if (num > bushelsGrain) {
                System.out.println("O no! You do not have enough grain for that!");
                continue;
            } else {
                bushelsGrain -= num;
                break;
            }
        }

    }

    public void askHowManyAcresToPlant() {
        int num = getNumber("How many acres of grain do you wish to plant? \n");
        for (int i = 0; i <= acres; i++);
        if (num)
    }

    int getNumber(String message) {

        while (true) {
            System.out.print(message);
            try {
                int input = scan.nextInt();
                if (input < 0) continue;
                return input;
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + scan.next() + "\" isn't a number!");
            }
        }
    }

}

