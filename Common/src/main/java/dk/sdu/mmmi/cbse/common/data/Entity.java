package dk.sdu.mmmi.cbse.common.data;

import java.io.Serializable;
import java.util.UUID;

public class Entity implements Serializable {

    private final UUID ID = UUID.randomUUID();

    private double[] polygonCoordinates;
    private double x;
    private double y;
    private double width;
    private double height;
    private double rotation;
    private boolean collisionHandled; // New field to track collision handling

    public String getID() {
        return ID.toString();
    }

    public void setPolygonCoordinates(double... coordinates ) {
        this.polygonCoordinates = coordinates;
    }

    public double[] getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public void setX(double x) {
        this.x =x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight (double height) {
        this.height = height;
    }

    public double getWidth () {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public double getRotation() {
        return rotation;
    }

    public boolean outOfBounds(int screenx, int screeny) {
        return x < 0 || x > screenx || y < 0 || y > screeny;
    }

    public void handleCollision(GameData gameData, World world, Entity collideEntity) {
        // Implementation for handling collision
    }

    // Method to check if collision has been handled
    public boolean hasCollisionHandled() {
        return collisionHandled;
    }

    // Method to set collisionHandled flag
    public void setCollisionHandled(boolean collisionHandled) {
        this.collisionHandled = collisionHandled;
    }
}