package hammurabi;

import java.util.Random;
import java.util.Scanner;

public class Console {
    Random rand = new Random();

    public static void main(String\[\] args) {
        new Console().playGame();
    }

    public void playGame() {

        int acres = 0;
        int grain = 0;
        int population = 0;

        //initial state summary
        System.out.println("O great Hammurabi!\n" +
                "You are in year 1 of your ten year rule.\n" +
                "In the previous year 0 people starved to death.\n" +
                "In the previous year 5 people entered the kingdom.\n" +
                "The population is now 100.\n" +
                "We harvested 3000 bushels at 3 bushels per acre.\n" +
                "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                "The city owns 1000 acres of land.\n" +
                "Land is currently worth 19 bushels per acre.");
        // call methods in loop here?

        System.out.println ("How many acres of land do you wish to buy?");
        Scanner scan = new Scanner(System.in); //Create a scanner object
        int acres = scan.nextLine(); //Read user input



    }
}
