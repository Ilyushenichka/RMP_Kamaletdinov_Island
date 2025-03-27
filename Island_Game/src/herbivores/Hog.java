package herbivores;

import animals.Animal;
import simulation.Area;

public class Hog extends Herbivore {
    public Hog() {
        super("Hog\uD83D\uDC17", 400, 2, 50);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Hog();
    }
} 