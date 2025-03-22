import java.util.Iterator;
import java.util.Map;
import java.util.Random;

abstract class LivingBeing {
    protected String name;
    protected int speed;
    protected double maxFood;
    protected double weight;
    protected boolean isAlive = true;

    public LivingBeing(String name, int speed, double maxFood, double weight) {
        this.name = name;
        this.speed = speed;
        this.maxFood = maxFood;
        this.weight = weight;
    }

    public String getName() { return name; }
    public abstract void consume(Area area);
    public void move(Island island, int currentX, int currentY) {
        Random rand = new Random();
        int newX = Math.max(0, Math.min(island.getWidth() - 1, currentX + rand.nextInt(3) - 1));
        int newY = Math.max(0, Math.min(island.getHeight() - 1, currentY + rand.nextInt(3) - 1));
        island.relocateBeing(this, currentX, currentY, newX, newY);
    }
    public abstract LivingBeing reproduce();
}


class Rabbit extends LivingBeing {
    public Rabbit() { super("Rabbit\uD83D\uDC07", 2, 4, 2.5); }

    @Override
    public void consume(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Rabbit(); }
}

class Mouse extends LivingBeing {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(Caterpillar.class, 90);

    public Mouse() { super("Mouse\uD83D\uDC01", 1, 2, 0.5); }

    @Override
    public void consume(Area area) {
        Iterator<LivingBeing> iterator = area.beings.iterator();
        boolean hasEaten = false;

        while (iterator.hasNext()) {
            LivingBeing prey = iterator.next();
            if (diet.containsKey(prey.getClass()) && Math.random() * 100 < diet.get(prey.getClass())) {
                iterator.remove();
                System.out.println(name + " съел " + prey.getName());
                hasEaten = true;
                break;
            }
        }

        if (!hasEaten && area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Mouse(); }
}

class Deer extends LivingBeing {
    public Deer() { super("Deer\uD83E\uDD8C", 3, 6, 80.0); }

    @Override
    public void consume(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Deer(); }
}

class Horse extends LivingBeing {
    public Horse() { super("Horse\uD83D\uDC0E", 4, 10, 120.0); }

    @Override
    public void consume(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Horse(); }
}

class Goat extends LivingBeing {
    public Goat() { super("Goat\uD83D\uDC10", 3, 10, 60.0); }

    @Override
    public void consume(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Goat(); }
}

class Sheep extends LivingBeing {
    public Sheep() { super("Sheep\uD83D\uDC11", 3, 15, 70.0); }

    @Override
    public void consume(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Sheep(); }
}

class Hog extends LivingBeing {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(Mouse.class, 50, Caterpillar.class, 90);

    public Hog() { super("Hog\uD83D\uDC17", 2, 50, 400.0); }

    @Override
    public void consume(Area area) {
        Iterator<LivingBeing> iterator = area.beings.iterator();
        boolean hasEaten = false;

        while (iterator.hasNext()) {
            LivingBeing prey = iterator.next();
            if (diet.containsKey(prey.getClass()) && Math.random() * 100 < diet.get(prey.getClass())) {
                iterator.remove();
                System.out.println(name + " съел " + prey.getName());
                hasEaten = true;
                break;
            }
        }

        if (!hasEaten && area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Hog(); }
}

class Buffalo extends LivingBeing {
    public Buffalo() { super("Buffalo\uD83D\uDC03", 3, 100, 700.0); }

    @Override
    public void consume(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Buffalo(); }
}

class Duck extends LivingBeing {
    private static final Map<Class<? extends LivingBeing>, Integer> diet = Map.of(Caterpillar.class, 90);

    public Duck() { super("Duck\uD83E\uDD86", 4, 0.15, 1.0); }

    @Override
    public void consume(Area area) {
        Iterator<LivingBeing> iterator = area.beings.iterator();
        boolean hasEaten = false;

        while (iterator.hasNext()) {
            LivingBeing prey = iterator.next();
            if (diet.containsKey(prey.getClass()) && Math.random() * 100 < diet.get(prey.getClass())) {
                iterator.remove();
                System.out.println(name + " съел " + prey.getName());
                hasEaten = true;
                break;
            }
        }

        if (!hasEaten && area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Duck(); }
}

class Caterpillar extends LivingBeing {
    public Caterpillar() { super("Caterpillar\uD83D\uDC1B", 0, 0, 0.01); }

    @Override
    public void consume(Area area) {
        if (area.plantCount > 0) {
            area.plantCount--;
            System.out.println(name + " ест траву.\uD83C\uDF3F");
        }
    }

    @Override public LivingBeing reproduce() { return new Caterpillar(); }
}
