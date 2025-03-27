package herbivores;

import animals.Animal;
import simulation.Area;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        super("Caterpillar\uD83D\uDC1B", 0.01, 0, 0);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Caterpillar();
    }
} 