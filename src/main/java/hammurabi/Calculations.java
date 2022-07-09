package hammurabi;

import java.util.*;
public class Calculations {
    // calls from Console class come here to these methods
    static Random rand = new Random();
    public Integer plagueDeaths(int population) {
        if (rand.nextInt(100) < 15) {
            return population / 2;
        }
        return 0;
    }

    public Integer starvationDeaths(int population, int bushelsFedToPeople) {
        if (population * 20 < bushelsFedToPeople) return 0;
        return population - (bushelsFedToPeople / 20);
    }

    public Boolean uprising(int population, int howManyPeopleStarved) {
        return (double)howManyPeopleStarved/population > 0.45;
    }

    public Integer immigrants(int population, int acresOwned, int grainInStorage) {
        return (20 * acresOwned + grainInStorage) / (100 * population) + 1;
    }

    public Integer harvest(int acres, int bushelsUsedAsSeed) {
        return null;
    }

    public Integer grainEatenByRats(int bushels) {
        return null;
    }

    public Integer newCostOfLand() {
        return null;
    }
}
