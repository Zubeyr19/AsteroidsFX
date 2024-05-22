package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public class Asteroid extends Entity {

    private int asteroidSize;
    private final AsteroidPlugin asteroidPlugin = new AsteroidPlugin();

    @Override
    public void handleCollision(GameData gameData, World world, Entity collidingEntity) {
        switch (getAsteroidSize()) {
            case 1:
                handleAsteroidSizeOne(world, collidingEntity);
                break;
            case 2:
                handleAsteroidSizeTwo(gameData, world, collidingEntity);
                break;
            case 3:
                handleAsteroidSizeThree(gameData, world, collidingEntity);
                break;
            default:
                handleDefaultAsteroidSize(gameData, world, collidingEntity);
                break;
        }
    }

    private void handleAsteroidSizeOne(World world, Entity collidingEntity) {
        world.removeEntity(collidingEntity);
        world.removeEntity(this);
    }

    private void handleAsteroidSizeTwo(GameData gameData, World world, Entity collidingEntity) {
        spawnChildAsteroids(gameData, world, 1);
        world.removeEntity(collidingEntity);
        world.removeEntity(this);
    }

    private void handleAsteroidSizeThree(GameData gameData, World world, Entity collidingEntity) {
        spawnChildAsteroids(gameData, world, 2);
        world.removeEntity(collidingEntity);
        world.removeEntity(this);
    }

    private void handleDefaultAsteroidSize(GameData gameData, World world, Entity collidingEntity) {
        spawnChildAsteroids(gameData, world, 3);
        world.removeEntity(collidingEntity);
        world.removeEntity(this);
    }

    private void spawnChildAsteroids(GameData gameData, World world, int newAsteroidSize) {
        for (int i = 0; i < 2; i++) {
            Asteroid asteroidChild = (Asteroid) asteroidPlugin.createAsteroid(gameData);
            AsteroidUtils.setAsteroidCoordinates(asteroidChild, newAsteroidSize);
            asteroidChild.setX(this.getX());
            asteroidChild.setY(this.getY());
            asteroidChild.setRotation(Math.random() * 360);
            world.addEntity(asteroidChild);
        }
    }

    public int getAsteroidSize() {
        return asteroidSize;
    }

    public void setAsteroidSize(int asteroidSize) {
        this.asteroidSize = asteroidSize;
    }
}