package segments;

import enemy.Enemy;
import support.SupportOperations;
import segments.segmentswork.SegmentsTextConstants;
import game.*;

//import java.util.Arrays;
import java.util.Objects;

public abstract class Segment {
    private final MapGame mapGame;
    public final Game game;
    public String description;
    public final int id;
    public final int parent_id;
    public int[] child_id; // чтобы было несколько проходов

    protected Segment(String description, MapGame mapGame, int parent_id, Game game) {
        this.id = mapGame.segmentID; // сначала нужно указать id, потому что после добавления сегмента, оно увеличивается
        mapGame.addSegment(this);
        this.mapGame = mapGame;
        this.game = game;
        this.description = description;
        this.parent_id = parent_id;
        this.child_id = new int[3]; // вперед, влево, вправо
    }
    private Segment createRandSegment() {
        if (game.getWAY_LENGTH() <= mapGame.getMapLength() && !game.isWinFound()) {
            return new WinSegment(mapGame, this.id, game);
        } else if (game.getWAY_LENGTH() <= mapGame.getMapLength() && game.isWinFound()) {
            return new DeadEndSegment(mapGame, this.id, game);
        }

        int randI = SupportOperations.randInRange(0, SegmentsTextConstants.ALL_PLAYABLE_TYPES_SEGMENTS.length - 1);
        switch (SegmentsTextConstants.ALL_PLAYABLE_TYPES_SEGMENTS[randI]) {
            case SegmentsTextConstants.CORRIDOR_SEGMENT -> {
                return new CorridorSegment(mapGame, this.id, game);
            }
            case SegmentsTextConstants.FORK_SEGMENT -> {
                return new ForkSegment(mapGame, this.id, game);
            }
            case SegmentsTextConstants.TREASURE_SEGMENT -> {
                return new TreasureCorridorSegment(mapGame, this.id, game);
            }
        }
        return null;
    }

    private static void fightActivity(Enemy enemy, Game game) {
        while (enemy.getHealth() > 0 && !enemy.isRunAway() && game.player.getHealth() > 0) {
            enemy.playFight();
        }
    }

    public abstract void playSegment();

    protected void goForward() {
        Enemy enemy = Enemy.chanceEnemySpawn(game);
        if (enemy != null) fightActivity(enemy, game);
        if (game.player.getHealth() == 0) {
            System.out.println("Вас убили.");
            game.endGame();
            return;
        } // player dead

        if (this.child_id[0] != 0) mapGame.getSegment(this.child_id[0]).playSegment();
        else {
            Segment childSegment = Objects.requireNonNull(this.createRandSegment());
            this.child_id[0] = childSegment.id;
            childSegment.playSegment();
        }
    }
    protected void goForward(int i) {
        Enemy enemy = Enemy.chanceEnemySpawn(game);
        if (enemy != null) fightActivity(enemy, game);
        if (game.player.getHealth() == 0) {
            System.out.println("Вас убили.");
            game.endGame();
            return;
        } // player dead
/*
        System.out.println("ID СЕГМЕНТА = " + id);
        System.out.println("ID РОДИТЕЛЯ = " + parent_id);
        System.out.println("ID ДЕТЕЙ = " + Arrays.toString(child_id));
*/
        if (this.child_id[i] != 0) mapGame.getSegment(this.child_id[i]).playSegment();
        else {
            Segment childSegment = Objects.requireNonNull(this.createRandSegment());
            this.child_id[i] = childSegment.id;
            childSegment.playSegment();
        }
    }

    protected void goBackward() {
        if (this.id == 0) {
            game.endGame();
        } else {
            Enemy enemy = Enemy.chanceEnemySpawn(game);
            if (enemy != null) fightActivity(enemy, game);
            if (game.player.getHealth() == 0) return; // player dead
            mapGame.getSegment(this.parent_id).playSegment();
        }
    }
}
