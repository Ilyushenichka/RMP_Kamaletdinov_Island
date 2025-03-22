import java.util.Iterator;
import java.util.Map;

abstract class Predator extends LivingBeing {
    protected final Map<Class<? extends LivingBeing>, Integer> diet;
    private boolean isHungry = false;
    private int hungerLevel = 5;

    public Predator(String name, int speed, int maxFood, double weight, Map<Class<? extends LivingBeing>, Integer> diet) {
        super(name, speed, maxFood, weight);
        this.diet = diet;
    }

    protected void hunt(Area area) {
        Iterator<LivingBeing> iterator = area.beings.iterator();
        boolean hasEaten = false;

        while (iterator.hasNext()) {
            LivingBeing prey = iterator.next();
            if (diet.containsKey(prey.getClass()) && Math.random() * 100 < diet.get(prey.getClass())) {
                iterator.remove();
                isHungry = true;
                hungerLevel = 5;
                System.out.println(name + " съел " + prey.name);
                hasEaten = true;
                break;
            }
        }

        if (!hasEaten) {
            hungerLevel--;
            if (hungerLevel <= 0) {
                System.out.println(name + " умер от голода.");
                area.beings.remove(this);
            }
        }
    }

    @Override
    public LivingBeing reproduce() {
        if (isHungry && hungerLevel > 2 && Math.random() < 0.1) {
            isHungry = false;
            System.out.println(name + " размножился.");
            return createNew();
        }
        return null;
    }

    protected abstract LivingBeing createNew();
}

class Wolf extends Predator {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(
            Rabbit.class, 60, Deer.class, 40, Mouse.class, 80, Horse.class, 10,
            Goat.class, 60, Sheep.class, 70, Hog.class, 15, Buffalo.class, 10, Duck.class, 40
    );

    public Wolf() { super("Wolf\uD83D\uDC3A", 3, 8, 50.0, diet); }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    protected LivingBeing createNew() {
        return new Wolf();
    }

    @Override public LivingBeing reproduce() { return new Wolf(); }
}

class Fox extends Predator {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(
            Rabbit.class, 70, Mouse.class, 90, Duck.class, 60, Caterpillar.class, 40
    );

    public Fox() { super("Fox\uD83E\uDD8A", 2, 2, 8.0, diet); }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    protected LivingBeing createNew() {
        return new Fox();
    }

    @Override public LivingBeing reproduce() { return new Fox(); }
}

class Bear extends Predator {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(
            Boa.class, 80, Horse.class, 40, Deer.class, 80, Rabbit.class, 80,
            Mouse.class, 90, Goat.class, 70, Sheep.class, 70, Hog.class, 50, Buffalo.class, 20, Duck.class, 10
    );

    public Bear() { super("Bear\uD83D\uDC3B", 2, 15, 200.0, diet); }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    protected LivingBeing createNew() {
        return new Bear();
    }

    @Override public LivingBeing reproduce() { return new Bear(); }
}

class Eagle extends Predator {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(
            Fox.class, 10, Rabbit.class, 90, Mouse.class, 90, Duck.class, 80
    );

    public Eagle() { super("Eagle\uD83E\uDD85", 4, 3, 6.0, diet); }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    protected LivingBeing createNew() {
        return new Eagle();
    }

    @Override public LivingBeing reproduce() { return new Eagle(); }
}

class Boa extends Predator {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(
            Fox.class, 15, Rabbit.class, 20, Mouse.class, 40, Duck.class, 10
    );

    public Boa() { super("Boa\uD83D\uDC0D", 1, 3, 15.0, diet); }

    @Override
    public void consume(Area area) {
        hunt(area);
    }

    @Override
    protected LivingBeing createNew() {
        return new Boa();
    }

    @Override public LivingBeing reproduce() { return new Boa(); }
}
