import support.SupportOperations;
import segmentswork.SegmentsConstants;

import java.util.Arrays;
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

        int randI = SupportOperations.randInRange(0, SegmentsConstants.ALL_PLAYABLE_TYPES_SEGMENTS.length - 1);
        switch (SegmentsConstants.ALL_PLAYABLE_TYPES_SEGMENTS[randI]) {
            case SegmentsConstants.CORRIDOR_SEGMENT -> {
                return new CorridorSegment(mapGame, this.id, game);
            }
            case SegmentsConstants.FORK_SEGMENT -> {
                return new ForkSegment(mapGame, this.id, game);
            }
            case SegmentsConstants.TREASURE_SEGMENT -> {
                return new TreasureCorridorSegment(mapGame, this.id, game);
            }
        }
        return null;
    }

    public abstract void playSegment();

    protected void goForward() {
        if (this.child_id[0] != 0) mapGame.getSegment(this.child_id[0]).playSegment();
        else {
            Segment childSegment = Objects.requireNonNull(this.createRandSegment());
            this.child_id[0] = childSegment.id;
            childSegment.playSegment();
        }
    }
    protected void goForward(int i) {
        System.out.println("ID СЕГМЕНТА = " + id);
        System.out.println("ID РОДИТЕЛЯ = " + parent_id);
        System.out.println("ID ДЕТЕЙ = " + Arrays.toString(child_id));
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
            System.out.println("ID СЕГМЕНТА = " + id);
            System.out.println("ID РОДИТЕЛЯ = " + parent_id);
            System.out.println("ID ДЕТЕЙ = " + Arrays.toString(child_id));
            mapGame.getSegment(this.parent_id).playSegment();
        }
    }
}
