package hammurabi.src.main.java;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    int year;
    int bushels;
    int population;
    int acresOfLand;
    int landValue;
    int landToFarm;
    int totalDeaths;
    int grainToEat;
    int plagueDeaths;
    int starvationDeaths;
    boolean uprising = false;
    int immigrants;

    int efficiency;


    public static void main(String[] args) {
        Hammurabi ham = new Hammurabi();
        ham.playGame();

    }

    void playGame(){
        gameInit();

        askHowManyAcresToBuy(this.landValue, this.bushels);
        askHowManyAcresToSell(this.acresOfLand);
        askHowMuchGrainToFeedPeople(this.bushels);
        askHowManyAcresToPlant(this.acresOfLand, this.population, this.bushels);

        plagueDeaths(this.population);
        starvationDeaths(this.population, this.grainToEat);
        uprising(this.population, this.starvationDeaths);

        if(starvationDeaths == 0){
            immigrants(this.population, this.acresOfLand, this.bushels);
        }

        harvest(this.la);








    }

    public void gameInit(){
        year = 1;
        bushels = 2800;
        population = 100;
        acresOfLand = 1000;
        landValue = 19;

        System.out.println("   ▄█    █▄       ▄████████   ▄▄▄▄███▄▄▄▄     ▄▄▄▄███▄▄▄▄   ███    █▄     ▄████████    ▄████████ ▀█████████▄   ▄█  \n" +
                "  ███    ███     ███    ███ ▄██▀▀▀███▀▀▀██▄ ▄██▀▀▀███▀▀▀██▄ ███    ███   ███    ███   ███    ███   ███    ███ ███  \n" +
                "  ███    ███     ███    ███ ███   ███   ███ ███   ███   ███ ███    ███   ███    ███   ███    ███   ███    ███ ███▌ \n" +
                " ▄███▄▄▄▄███▄▄   ███    ███ ███   ███   ███ ███   ███   ███ ███    ███  ▄███▄▄▄▄██▀   ███    ███  ▄███▄▄▄██▀  ███▌ \n" +
                "▀▀███▀▀▀▀███▀  ▀███████████ ███   ███   ███ ███   ███   ███ ███    ███ ▀▀███▀▀▀▀▀   ▀███████████ ▀▀███▀▀▀██▄  ███▌ \n" +
                "  ███    ███     ███    ███ ███   ███   ███ ███   ███   ███ ███    ███ ▀███████████   ███    ███   ███    ██▄ ███  \n" +
                "  ███    ███     ███    ███ ███   ███   ███ ███   ███   ███ ███    ███   ███    ███   ███    ███   ███    ███ ███  \n" +
                "  ███    █▀      ███    █▀   ▀█   ███   █▀   ▀█   ███   █▀  ████████▀    ███    ███   ███    █▀  ▄█████████▀  █▀   \n" +
                "                                                                         ███    ███                                ");
        System.out.println("Congratulations, you are the newest ruler of ancient Sumer, elected for a ten year term of office." +
                "\nYour duties are to dispense food, direct farming, and buy and sell land as needed to support your people." +
                "\nWatch out for rat infestiations and the plague! Grain is the general currency, measured in bushels." +
                "\nThe following will help you in your decisions:\n" +
                "\n" +
                "Each person needs at least 20 bushels of grain per year to survive\n" +
                "Each person can farm at most 10 acres of land\n" +
                "It takes 2 bushels of grain to farm an acre of land\n" +
                "The market price for land fluctuates yearly\n" +
                "Rule wisely and you will be showered with appreciation at the end of your term.\n" +
                "Rule poorly and you will be sacrificed to the blood gods!");


    }

    public void summaryOfYear(){
        System.out.println(
                "O' great Hammurabi!\n" +
                "You are in year " + year + " of your ten year rule.\n" +
                "In the previous year 0 people starved to death.\n" +
                "In the previous year 5 people entered the kingdom.\n" +
                "The population is now 1000.\n" +
                "We harvested 3000 bushels at 3 bushels per acre.\n" +
                "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                "The city owns 1000 acres of land.\n" +
                "Land is currently worth 19 bushels per acre.");
    }

    int getAcresToBuy(String message) {
        int acresToBuy = 0;
        while (true) {
            System.out.print(message);
            try {
                acresToBuy = scanner.nextInt();
                if(acresToBuy > bushels / landValue){
                    System.out.println("Sire surely you jest, we have only " + bushels + " of grain to spend!");
                } else if(acresToBuy < 0){
                    System.out.println("Sire we are buying land now, not selling it!");
                } else if(acresToBuy == 0){
                    break;
                }
                else break;
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + acresToBuy + "\" isn't a number!");
                scanner.next();
            }
        }
        bushels -= acresToBuy * landValue;
        acresOfLand += acresToBuy;
        return acresToBuy;
    }
    int getAcresToSell(String message) {
        int acresToSell = 0;
        while (true) {
            System.out.print(message);
            try {
                acresToSell = scanner.nextInt();
                if(acresToSell > acresOfLand){
                    System.out.println("Sire surely you jest, we have only " + acresOfLand + " acres of land to sell!");
                } else if(acresToSell < 0){
                    System.out.println("Sire we are selling land now, not buying it!");
                } else if(acresToSell == 0){
                    break;
                }
                else break;
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + acresToSell + "\" isn't a number!");
                scanner.next();
            }

        }
        acresOfLand -= acresToSell;
        bushels += acresToSell * landValue;
        return acresToSell;
    }

    int getGrainToEat(String message) {
        int grainToEat = 0;
        while (true) {
            System.out.print(message);
            try {
                grainToEat = scanner.nextInt();
                if(grainToEat > bushels){
                    System.out.println("Sire surely you jest, we have only " + bushels + " of grain to use!");
                } else if(grainToEat < 0){
                    System.out.println("Sire if we steal the peasants food, they will surely pave the streets with your blood!");
                } else if(grainToEat == 0){
                    System.out.println("Sire if we don't feed our people, we will have no kingdom to rule!");
                }
                else break;
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + grainToEat + "\" isn't a number!");
                scanner.next();
            }

        }
        bushels -= grainToEat;
        return this.grainToEat = grainToEat;
    }

    int getLandToFarm(String message) {
        int landToFarm = 0;
        while (true) {
            System.out.print(message);
            try {
                landToFarm = scanner.nextInt();
                if(landToFarm > acresOfLand / (population * 10)){
                    System.out.println("Sire surely you jest, we do not have enough workers to farm that land!");
                } else if(landToFarm < 0){
                    System.out.println("Sire we are not in the position to destroy our farmland!");
                } else if(landToFarm == 0){
                    System.out.println("Sire if we don't feed our people, we will have no kingdom to rule!");
                }
                else break;
            }
            catch (InputMismatchException e) {
                System.out.println("\"" + landToFarm + "\" isn't a number!");
                scanner.next();
            }

        }
        bushels -= landToFarm * 2;
        return this.landToFarm = landToFarm;
    }

    public int askHowManyAcresToBuy(int price, int bushels){
        int buy = getAcresToBuy("O' great Hammurabi, how many acres of land should we purchase?");
        return buy;
        }



    public int askHowManyAcresToSell(int acresOwned){
        int sell = getAcresToSell("0' great Hammurabi, how many acres of land should we sell?");
        return sell;

    }

    public int askHowMuchGrainToFeedPeople(int bushels){
        int grainToGive = getGrainToEat("O' great Hammurabi, how much grain should we give our people?");
        return grainToGive;


    }
    public int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        int acresToPlant = getLandToFarm("O' great Hammurabi, how much land should we farm this year?");
        return acresToPlant;
    }

    public int plagueDeaths(int population){
        int plagueDeaths = 0;
        int spreadPlague = (int) Math.random();
        if(spreadPlague <= 0.15){
            System.out.println("O' great Hammurabi! A plague is ravaging the land! Our population will surely suffer!");
            plagueDeaths = population / 2;
            this.population -= plagueDeaths;
            return this.plagueDeaths = plagueDeaths;

        } else return this.plagueDeaths = plagueDeaths;
    }

    public int starvationDeaths(int population, int bushelsToFeedPeople){
        int starvationDeaths = 0;
        if((population * 20) > bushelsToFeedPeople){
            System.out.println("O' great Hammurabi, you did not feed enough people! Some of your followers will starve to death!");
            starvationDeaths = (population * 20) % bushelsToFeedPeople;
            return this.starvationDeaths = starvationDeaths;
        } else return this.starvationDeaths = starvationDeaths;
    }

    public boolean uprising(int population, int starvationDeaths){
        if(starvationDeaths >= (int)(population * 0.45) * 100){
            System.out.println("O' moronic Hammurabi, for starving your people you will be sacrificed to the blood gods!");
            return this.uprising = true;
        } else return this.uprising = false;
    }

    public int immigrants(int population, int acresOfLand, int bushels){
        int immigrants;
        immigrants = (20 * acresOfLand + bushels) / (100 * population) + 1;
        return this.immigrants = immigrants;
    }

    public int harvest(int landUsedForFarming){
        int bushelsHarvested = 0;
        this.efficiency = (rand.nextInt(7) + 1);
        this.bushels += bushelsHarvested * efficiency;
        return bushelsHarvested;
    }
    public int grainEatenByRats(int bushels){
        int ratInfestation = 0;
        int bushelsEatenByRats = 0;
        


    }



}
