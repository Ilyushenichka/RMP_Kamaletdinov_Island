package herbivores;

import animals.Animal;
import simulation.Area;

public class Mouse extends Herbivore {
    public Mouse() {
        super("Mouse\uD83D\uDC01", 0.05, 1, 1);
    }

    @Override
    public void consume(Area area) {
        eatPlants(area);
    }

    @Override
    public Animal reproduce() {
        return new Mouse();
    }
} 