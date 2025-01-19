package enemy;

import game.Game;
import support.SupportOperations;

import java.util.Scanner;

public abstract class Enemy {
    private final Game game;
    private final int PERCENT_OF_RUNAWAY;
    private int health;
    public final String description;
    public final int pointsForKill;
    public final int damage;
    private boolean isRunAway;

    private static final String[] ENEMY_TYPES = new String[] {"sk", "ogr"};

    protected Enemy(int damage, int health, int pointsForKill, String description, Game game) {
        this.game = game;
        this.health = health;
        this.damage = damage;
        this.pointsForKill = pointsForKill;
        this.isRunAway = false;
        this.description = description;
        this.PERCENT_OF_RUNAWAY = 90 / game.getDIFFICULT();
    }

    public void takeDamage(int enemyDamage) {
        health -= enemyDamage;
        health = Math.max(0, health);
    }

    public int getHealth() {
        return health;
    }

    public boolean isRunAway() {
        return isRunAway;
    }

    public void playFight() {
        Scanner sc = new Scanner(System.in);
        System.out.print(this.description);
        String playerMessage = sc.nextLine().toLowerCase();
        switch (playerMessage) {
            case "драться": {
                int playerDamage = game.player.inventory.getSword().DAMAGE;
                int playerArmor = game.player.inventory.getArmor().ARMOR;
                this.takeDamage(playerDamage); // enemy gets punch
                game.player.takeDamage(this.damage - playerArmor); // player gets punch
                System.out.println("-------БОЙ-------");
                System.out.println("ВЫ НАНОСИТЕ УДАР (" + playerDamage + " УРОНА)");
                System.out.println("ХП ВРАГА: " + this.health);
                System.out.println("ВАМ НАНОСЯТ УДАР (" + this.damage + " УРОНА. " + playerArmor + " УРОНА ПОГЛОЩАЕТСЯ БРОНЕЙ):");
                System.out.println("ВАШЕ ХП: " + game.player.getHealth());
                System.out.println("-------БОЙ-------");

                if (this.health == 0) {
                    game.player.givePoints(this.pointsForKill);
                    System.out.println("Вы успешно убили противника. Вам добавлено " + this.pointsForKill + " очков.");
                    System.out.println("-------БОЙ-------\n");
                    return;
                }
                return;
            }
            case "убежать": {
                boolean canRun = SupportOperations.randInRange(1, 100) <= PERCENT_OF_RUNAWAY; // chance
                if (canRun) {
                    isRunAway = true;
                    game.player.givePoints(100);
                    System.out.println("-------БОЙ-------");
                    System.out.println("Вы успешно убежали. Вам добавлено 100 очков.");
                    System.out.println("-------БОЙ-------");
                } else {
                    int playerArmor = game.player.inventory.getArmor().ARMOR;
                    game.player.takeDamage(this.damage - playerArmor); // player gets punch
                    System.out.println("-------БОЙ-------");
                    System.out.println("УБЕЖАТЬ НЕ УДАЛОСЬ, ВЫ ПОЛУЧАЕТЕ УДАР. ВЫ ПРОПУСКАЕТЕ ХОД.");
                    System.out.println("ХП ВРАГА: " + this.health);
                    System.out.println("ВАМ НАНОСЯТ УДАР (" + this.damage + "УРОНА. " + playerArmor + " УРОНА ПОГЛОЩАЕТСЯ БРОНЕЙ):");
                    System.out.println("ВАШЕ ХП: " + game.player.getHealth());
                    System.out.println("-------БОЙ-------");
                }
            }
        }
    }

    public static Enemy chanceEnemySpawn(Game game) {
        if (SupportOperations.randInRange(1, 100) <= 7 * game.getDIFFICULT()) {
            String enemyType = SupportOperations.takeRandObjectFromArray(ENEMY_TYPES);
            switch (enemyType) {
                case "sk": return new Skeleton(game);
                case "ogr": return new Ogre(game);
            }
        }
        return null;
    }
}
