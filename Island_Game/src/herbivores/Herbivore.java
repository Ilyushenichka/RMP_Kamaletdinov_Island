package herbivores;

import animals.Animal;
import simulation.Area;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, double weight, int speed, double maxFood) {
        super(name, speed, maxFood, weight);
    }
    
    protected void eatPlants(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(getName() + " ест траву.\uD83C\uDF3F");
        }
    }
} 