package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.Map;
import java.util.HashMap;

public class AsteroidUtils {

    private static class AsteroidConfig {
        final double[] coordinates;
        final int width;
        final int height;
        final int size;

        AsteroidConfig(double[] coordinates, int width, int height, int size) {
            this.coordinates = coordinates;
            this.width = width;
            this.height = height;
            this.size = size;
        }
    }

    // Map to hold configurations for each asteroid size
    private static final Map<Integer, AsteroidConfig> asteroidConfigMap = new HashMap<>();

    static {
        asteroidConfigMap.put(1, new AsteroidConfig(
                new double[]{-9, 3, -3, 9, 3, 9, 9, 3, 9, -3, 3, -9, -3, -9, -9, -3, -9, 3},
                18,
                18,
                1
        ));
        asteroidConfigMap.put(2, new AsteroidConfig(
                new double[]{-18, 6, -6, 18, 6, 18, 18, 6, 18, -6, 6, -18, -6, -18, -18, -6, -18, 6},
                36,
                36,
                2
        ));
        asteroidConfigMap.put(3, new AsteroidConfig(
                new double[]{-36, 12, -12, 36, 12, 36, 36, 12, 36, -12, 12, -36, -12, -36, -36, -12, -36, 12},
                72,
                72,
                3
        ));
    }

    public static void setAsteroidCoordinates(Entity asteroid, int newAsteroidSize) {
        AsteroidConfig config = asteroidConfigMap.get(newAsteroidSize);
        if (config != null) {
            asteroid.setPolygonCoordinates(config.coordinates);
            asteroid.setWidth(config.width);
            asteroid.setHeight(config.height);
            ((Asteroid) asteroid).setAsteroidSize(config.size);
        } else {
            throw new IllegalArgumentException("Invalid asteroid size: " + newAsteroidSize);
        }
    }
}