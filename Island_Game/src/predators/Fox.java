package predators;

import animals.Animal;
import simulation.Area;
import herbivores.*;

public class Fox extends Predator {
    public Fox() {
        super("Fox\uD83E\uDD8A", 8, 2, 2);
    }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    public Animal reproduce() {
        return new Fox();
    }
    
    @Override
    protected Animal createNew() {
        return new Fox();
    }
    
    @Override
    protected boolean canEat(Animal animal) {
        return animal instanceof Rabbit || 
               animal instanceof Mouse || 
               animal instanceof Duck || 
               animal instanceof Caterpillar;
    }
    
    @Override
    protected int getProbability(Animal animal) {
        if (animal instanceof Rabbit) return 70;
        if (animal instanceof Mouse) return 90;
        if (animal instanceof Duck) return 60;
        if (animal instanceof Caterpillar) return 40;
        return 0;
    }
} 