package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;
    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    public Entity createAsteroid(GameData gameData) {

        Entity asteroid = new Asteroid();

        setAsteroidCoordinates(asteroid, 3);

        setAsteroidPosition(gameData, asteroid);
        asteroid.setX(gameData.getDisplayWidth()/2);
        asteroid.setY(0);
        asteroid.setRotation(90);
        return asteroid;
    }

    public void setAsteroidCoordinates(Entity asteroid, int newAsteroidSize) {

        switch(newAsteroidSize) {
            case 1:
                asteroid.setPolygonCoordinates(-9,3,-3,9,3,9,9,3,9,-3,3,-9,-3,-9,-9,-3,-9, 3);
                asteroid.setWidth(18);
                asteroid.setHeight(18);
                ((Asteroid) asteroid).setAsteroidSize(1);
                break;
            case 2:
                asteroid.setPolygonCoordinates(-18,6,-6,18,6,18,18,6,18,-6,6,-18,-6,-18,-18,-6,-18, 6);
                asteroid.setWidth(36);
                asteroid.setHeight(36);
                ((Asteroid) asteroid).setAsteroidSize(2);
                break;
            case 3:
                asteroid.setPolygonCoordinates(-36,12,-12,36,12,36,36,12,36,-12,12,-36,-12,-36,-36,-12,-36, 12);
                asteroid.setWidth(72);
                asteroid.setHeight(72);
                ((Asteroid) asteroid).setAsteroidSize(3);
                break;
        }
    }


    private void setAsteroidPosition(GameData gameData, Entity asteroid) {
        Random random = new Random();

        // Define possible starting positions and rotations
        Runnable[] positionSetters = new Runnable[]{
                // Set asteroid at the top
                () -> {
                    asteroid.setX(random.nextInt(gameData.getDisplayWidth()));
                    asteroid.setY(0);
                    asteroid.setRotation(random.nextDouble() * 180);
                },
                // Set asteroid at the bottom
                () -> {
                    asteroid.setX(random.nextInt(gameData.getDisplayWidth()));
                    asteroid.setY(gameData.getDisplayHeight());
                    asteroid.setRotation(-random.nextDouble() * 180);
                },
                // Set asteroid to the left
                () -> {
                    asteroid.setX(0);
                    asteroid.setY(random.nextInt(gameData.getDisplayHeight()));
                    asteroid.setRotation(random.nextDouble() * 180 - 90);
                },
                // Set asteroid to the right
                () -> {
                    asteroid.setX(gameData.getDisplayWidth());
                    asteroid.setY(random.nextInt(gameData.getDisplayHeight()));
                    asteroid.setRotation(random.nextDouble() * 180 + 90);
                }
        };

        // Select and run a random position setter
        positionSetters[random.nextInt(positionSetters.length)].run();
    }
    @Override
    public void stop(GameData gameData, World world) {

        world.removeEntity(asteroid);
    }
}