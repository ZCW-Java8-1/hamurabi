package hammurabi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    Scanner scan = new Scanner(System.in); //Create a scanner object
    int currentYear = 1;
    int acres = 1000;
    int bushelsGrain = 2800;
    int bushelsToFeed;
    int bushelsHarvested = 3000;
    int population = 100;
    int landValue = 19;
    int deaths = 0;
    int immigrants = 5;


    public void playGame() { // call methods in loop here?
        instructions();

        while(currentYear < 11) {
            summary();
            askHowManyAcresToBuy();
            askHowMuchGrainToFeedPeople();
            askHowManyAcresToPlant();

            population -= Calculations.plagueDeaths(population);

            deaths = Calculations.starvationDeaths(population, bushelsToFeed);
            if (Calculations.uprising(population,deaths)) {
                System.out.println("O great Hammurabi, you have failed your people. " +
                        "Too many people have starved and there has been an uprising. " +
                        "Your rule is now over." );
                break;
            }
            population -= deaths;

            if (deaths == 0) {
                immigrants = Calculations.immigrants(population, acres, bushelsGrain);
                population += immigrants;
            }
            currentYear++;
        }


    }

    public void instructions() {
        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office. Your duties are to dispense food, direct farming, and buy and sell land as needed to support your people. Watch out for rat infestiations and the plague! Grain is the general currency, measured in bushels. The following will help you in your decisions:\n" +
                "\n" +
                "Each person needs at least 20 bushels of grain per year to survive\n" +
                "Each person can farm at most 10 acres of land\n" +
                "It takes 2 bushels of grain to farm an acre of land\n" +
                "The market price for land fluctuates yearly\n" +
                "Rule wisely and you will be showered with appreciation at the end of your term. Rule poorly and you will be kicked out of office!");
    }
    public void summary() {
        System.out.println("O great Hammurabi!\n" +
                "You are in year " + currentYear + " of your ten year rule.\n" +
                "In the previous year "+deaths+" people starved to death.\n" +
                "In the previous year "+immigrants+" people entered the kingdom.\n" +
                "The population is now " + population + ".\n" +
                "We harvested " + bushelsHarvested + " bushels at 3 bushels per acre.\n" +
                "We now have "+bushelsGrain+" bushels of grain.\n" +
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
            } else {
                bushelsGrain -= num;
                bushelsToFeed = num;
                break;
            }
        }

    }

    public void askHowManyAcresToPlant() {

        while (true) {
            int num = getNumber("How many acres of grain do you wish to plant? \n");
            if (num > acres) {
                System.out.println("O no! You do not have enough land for that! \n");
            } else if (num * 10 > population ) {
                System.out.println("O no! You do not have enough people for that! \n");
            } else if (num * 2 > bushelsGrain) {
                System.out.println("O no! You do not have enough grain for that! \n");
            } else {
                bushelsHarvested = num;
                bushelsGrain += num; //Karem will add harvest method for randomization
                break;
            }
        }

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

