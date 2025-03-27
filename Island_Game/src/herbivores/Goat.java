package herbivores;

import animals.Animal;
import simulation.Area;

public class Goat extends Herbivore {
    public Goat() {
        super("Goat\uD83D\uDC10", 60, 3, 10);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Goat();
    }
} 