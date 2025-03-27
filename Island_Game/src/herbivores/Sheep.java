package herbivores;

import animals.Animal;
import simulation.Area;

public class Sheep extends Herbivore {
    public Sheep() {
        super("Sheep\uD83D\uDC11", 70, 3, 15);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Sheep();
    }
} 