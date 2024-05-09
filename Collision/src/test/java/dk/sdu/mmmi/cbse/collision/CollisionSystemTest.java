package dk.sdu.mmmi.cbse.collision;

import static org.junit.Assert.*;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.enemy.EnemySpaceship;
import dk.sdu.mmmi.cbse.playersystem.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystemTest {

    @Test
    public void testProcess() {
        // Create test data
        GameData gameData = new GameData();
        World world = new World();

        // Create entities for testing
        Entity player = new Player();
        player.setX(100);
        player.setY(100);
        player.setWidth(20);
        player.setHeight(20);

        Entity enemySpaceship = new EnemySpaceship();
        enemySpaceship.setX(150);
        enemySpaceship.setY(150);
        enemySpaceship.setWidth(20);
        enemySpaceship.setHeight(20);

        Entity bullet = new Bullet();
        bullet.setX(120);
        bullet.setY(120);
        bullet.setWidth(10);
        bullet.setHeight(10);

        Entity asteroid = new Asteroid();
        asteroid.setX(200);
        asteroid.setY(200);
        asteroid.setWidth(30);
        asteroid.setHeight(30);

        // Add entities to the world
        world.addEntity(player);
        world.addEntity(enemySpaceship);
        world.addEntity(bullet);
        world.addEntity(asteroid);

        // Create CollisionSystem instance
        CollisionSystem collisionSystem = new CollisionSystem();

        // Invoke the process method
        collisionSystem.process(gameData, world);

        // Assert expected outcomes

        // Example assertion: Check if collision was handled for player and bullet
        assertTrue(player.hasCollisionHandled());
        assertFalse(enemySpaceship.hasCollisionHandled());
        assertFalse(bullet.hasCollisionHandled());
        assertFalse(asteroid.hasCollisionHandled());
    }
}