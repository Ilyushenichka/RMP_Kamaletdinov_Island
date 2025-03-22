import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Island {
    private final int width;
    private final int height;
    private final Area[][] areas;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.areas = new Area[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                areas[i][j] = new Area();
            }
        }
        populateIsland();
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    private void populateIsland() {
        Random rand = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (rand.nextDouble() < 0.4) areas[i][j].beings.add(new Wolf());
                if (rand.nextDouble() < 0.4) areas[i][j].beings.add(new Bear());
                if (rand.nextDouble() < 0.4) areas[i][j].beings.add(new Boa());
                if (rand.nextDouble() < 0.4) areas[i][j].beings.add(new Fox());
                if (rand.nextDouble() < 0.4) areas[i][j].beings.add(new Eagle());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Deer());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Horse());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Rabbit());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Mouse());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Buffalo());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Duck());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Caterpillar());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Sheep());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Goat());
                if (rand.nextDouble() < 0.6) areas[i][j].beings.add(new Hog());
            }
        }
    }

    public void relocateBeing(LivingBeing being, int oldX, int oldY, int newX, int newY) {
        if (areas[oldX][oldY].beings.remove(being)) {
            areas[newX][newY].beings.add(being);
        }
    }

    public void simulate() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        scheduler.scheduleAtFixedRate(this::updateBeings, 0, 2, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::printStats, 0, 3, TimeUnit.SECONDS);
    }

    private void updateBeings() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                areas[i][j].plantCount = Math.min(10, areas[i][j].plantCount + 1);

                List<LivingBeing> beingsCopy = new ArrayList<>(areas[i][j].beings);
                for (LivingBeing being : beingsCopy) {
                    being.consume(areas[i][j]);
                    being.move(this, i, j);
                    if (Math.random() < 0.1) {
                        areas[i][j].beings.add(being.reproduce());
                    }
                }
            }
        }
    }

    private void printStats() {
        try {
            System.out.println("--- Статистика острова ---");
            boolean hasBeings = false;

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    List<LivingBeing> beingsCopy = new ArrayList<>(areas[i][j].beings);

                    if (!beingsCopy.isEmpty()) hasBeings = true;

                    Map<String, Integer> speciesCount = new HashMap<>();
                    for (LivingBeing being : beingsCopy) {
                        if (being != null) {
                            speciesCount.put(being.getName(), speciesCount.getOrDefault(being.getName(), 0) + 1);
                        }
                    }
                    System.out.println("Зона [" + i + ", " + j + "]: " + speciesCount + ", Растений: " + areas[i][j].plantCount);
                }
            }

            if (!hasBeings) {
                System.out.println("Все животные вымерли. Симуляция завершена.");
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
