package herbivores;

import animals.Animal;
import simulation.Area;

public class Horse extends Herbivore {
    public Horse() {
        super("Horse\uD83D\uDC0E", 400, 4, 60);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Horse();
    }
} 