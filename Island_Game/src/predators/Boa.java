package predators;

import animals.Animal;
import simulation.Area;
import herbivores.*;

public class Boa extends Predator {
    public Boa() {
        super("Boa\uD83D\uDC0D", 15, 1, 3);
    }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    public Animal reproduce() {
        return new Boa();
    }
    
    @Override
    protected Animal createNew() {
        return new Boa();
    }
    
    @Override
    protected boolean canEat(Animal animal) {
        return animal instanceof Rabbit || 
               animal instanceof Mouse || 
               animal instanceof Duck;
    }
    
    @Override
    protected int getProbability(Animal animal) {
        if (animal instanceof Rabbit) return 20;
        if (animal instanceof Mouse) return 40;
        if (animal instanceof Duck) return 10;
        return 0;
    }
} 