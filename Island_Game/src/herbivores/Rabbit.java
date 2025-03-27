package herbivores;

import animals.Animal;
import simulation.Area;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super("Rabbit\uD83D\uDC07", 2.5, 4, 2);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Rabbit();
    }
} 