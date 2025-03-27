package herbivores;

import animals.Animal;
import simulation.Area;

public class Buffalo extends Herbivore {
    public Buffalo() {
        super("Buffalo\uD83D\uDC03", 700, 3, 100);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Buffalo();
    }
} 