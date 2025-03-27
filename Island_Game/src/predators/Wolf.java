package predators;

import animals.Animal;
import simulation.Area;
import herbivores.*;

public class Wolf extends Predator {
    public Wolf() {
        super("Wolf\uD83D\uDC3A", 50, 3, 8);
    }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    public Animal reproduce() {
        return new Wolf();
    }
    
    @Override
    protected Animal createNew() {
        return new Wolf();
    }
    
    @Override
    protected boolean canEat(Animal animal) {
        return animal instanceof Rabbit || 
               animal instanceof Deer || 
               animal instanceof Mouse || 
               animal instanceof Horse || 
               animal instanceof Goat || 
               animal instanceof Sheep || 
               animal instanceof Hog || 
               animal instanceof Buffalo || 
               animal instanceof Duck;
    }
    
    @Override
    protected int getProbability(Animal animal) {
        if (animal instanceof Rabbit) return 60;
        if (animal instanceof Deer) return 15;
        if (animal instanceof Mouse) return 80;
        if (animal instanceof Horse) return 10;
        if (animal instanceof Goat) return 60;
        if (animal instanceof Sheep) return 70;
        if (animal instanceof Hog) return 15;
        if (animal instanceof Buffalo) return 10;
        if (animal instanceof Duck) return 40;
        return 0;
    }
} 