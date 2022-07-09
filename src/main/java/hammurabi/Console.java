package hammurabi;

import java.util.Random;
import java.util.Scanner;

public class Console {
    Random rand = new Random();
    int currentYear = 1;
    int acres = 1000;
    int bushels = 2800;
    int population = 100;
    int landValue = 19;

    public void playGame() {
        summary();

        // call methods in loop here?


    }
    public void summary() {
        System.out.println("O great Hammurabi!\n" +
                "You are in year "+currentYear+" of your ten year rule.\n" +
                //"In the previous year 0 people starved to death.\n" +
               //"In the previous year 5 people entered the kingdom.\n" +
                "The population is now "+population+".\n" +
                "We harvested "+bushels+" bushels at 3 bushels per acre.\n" +
               //"Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                "The city owns "+acres+" acres of land.\n"); //delete once next line is needed
                //"Land is currently worth "+landValue+" bushels per acre.");

        System.out.println ("How many acres of land do you wish to buy?");
        Scanner scan = new Scanner(System.in); //Create a scanner object
    }
}
