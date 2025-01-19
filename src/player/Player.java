package player;

import inventory_system.Inventory;

public class Player {
    private int health;
    private int points;
    public final Inventory inventory;

    public Player(Inventory inventory) {
        this.inventory = inventory;
        health = 100;
        points = 0;
    }

    public void takeDamage(int enemyDamage) {
        health -= enemyDamage;
        health = Math.max(0, health);
    }

    public void givePoints(int givenPoints) {
        points += givenPoints;
    }

    public int getPoints() {
        return points;
    }

    public int getHealth() {
        return health;
    }

}
