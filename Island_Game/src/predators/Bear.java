package predators;

import animals.Animal;
import simulation.Area;
import herbivores.*;

public class Bear extends Predator {
    public Bear() {
        super("Bear\uD83D\uDC3B", 500, 2, 80);
    }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    public Animal reproduce() {
        return new Bear();
    }
    
    @Override
    protected Animal createNew() {
        return new Bear();
    }
    
    @Override
    protected boolean canEat(Animal animal) {
        return animal instanceof Horse || 
               animal instanceof Deer || 
               animal instanceof Rabbit || 
               animal instanceof Mouse || 
               animal instanceof Goat || 
               animal instanceof Sheep || 
               animal instanceof Hog || 
               animal instanceof Buffalo || 
               animal instanceof Duck;
    }
    
    @Override
    protected int getProbability(Animal animal) {
        if (animal instanceof Horse) return 40;
        if (animal instanceof Deer) return 80;
        if (animal instanceof Rabbit) return 80;
        if (animal instanceof Mouse) return 90;
        if (animal instanceof Goat) return 70;
        if (animal instanceof Sheep) return 70;
        if (animal instanceof Hog) return 50;
        if (animal instanceof Buffalo) return 20;
        if (animal instanceof Duck) return 10;
        return 0;
    }
} 