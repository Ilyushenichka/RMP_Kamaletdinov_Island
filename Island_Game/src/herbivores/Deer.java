package herbivores;

import animals.Animal;
import simulation.Area;

public class Deer extends Herbivore {
    public Deer() {
        super("Deer\uD83E\uDD8C", 300, 4, 50);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Deer();
    }
} 