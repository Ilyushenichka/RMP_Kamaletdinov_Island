package predators;

import animals.Animal;
import simulation.Area;
import java.util.Iterator;
import java.util.Map;

public abstract class Predator extends Animal {
    private boolean isHungry = false;
    private int hungerLevel = 5;

    public Predator(String name, double weight, int speed, double maxFood) {
        super(name, speed, maxFood, weight);
    }

    protected void hunt(Area area) {
        Iterator<Animal> iterator = area.beings.iterator();
        boolean hasEaten = false;

        while (iterator.hasNext()) {
            Animal prey = iterator.next();
            if (canEat(prey) && Math.random() * 100 < getProbability(prey)) {
                iterator.remove();
                isHungry = true;
                hungerLevel = 5;
                System.out.println(getName() + " съел " + prey.getName());
                hasEaten = true;
                break;
            }
        }

        if (!hasEaten) {
            hungerLevel--;
            if (hungerLevel <= 0) {
                System.out.println(getName() + " умер от голода.");
                area.beings.remove(this);
            }
        }
    }

    protected boolean canEat(Animal animal) {
        return false;
    }
    
    protected int getProbability(Animal animal) {
        return 0;
    }

    @Override
    public Animal reproduce() {
        if (isHungry && hungerLevel > 2 && Math.random() < 0.1) {
            isHungry = false;
            System.out.println(getName() + " размножился.");
            return createNew();
        }
        return null;
    }

    protected abstract Animal createNew();
} 