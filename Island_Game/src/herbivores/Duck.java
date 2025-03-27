package herbivores;

import animals.Animal;
import simulation.Area;

public class Duck extends Herbivore {
    public Duck() {
        super("Duck\uD83E\uDD86", 1, 4, 1);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Duck();
    }
} 