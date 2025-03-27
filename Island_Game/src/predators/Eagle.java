package predators;

import animals.Animal;
import simulation.Area;
import herbivores.*;

public class Eagle extends Predator {
    public Eagle() {
        super("Eagle\uD83E\uDD85", 6, 3, 1);
    }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    public Animal reproduce() {
        return new Eagle();
    }
    
    @Override
    protected Animal createNew() {
        return new Eagle();
    }
    
    @Override
    protected boolean canEat(Animal animal) {
        return animal instanceof Rabbit || 
               animal instanceof Mouse || 
               animal instanceof Duck;
    }
    
    @Override
    protected int getProbability(Animal animal) {
        if (animal instanceof Rabbit) return 90;
        if (animal instanceof Mouse) return 90;
        if (animal instanceof Duck) return 80;
        return 0;
    }
} 