import support.SupportOperations;
import segmentswork.SegmentsConstants;

import java.util.Scanner;

public class Segment {
    private final MapGame mapGame;
    public final String description;
    public final int id;
    public final int parent_id;

    protected Segment(String description, MapGame mapGame, int parent_id) {
        this.description = description;
        this.mapGame = mapGame;
        this.id = mapGame.segmentID;
        this.parent_id = parent_id;
        mapGame.addSegment(this);
    }
    private static Segment createRandSegment(MapGame mapGame, int parent_id) {
        int randI = SupportOperations.randInRange(0, SegmentsConstants.ALL_TYPES_SEGMENTS.length - 1);
        switch (SegmentsConstants.ALL_TYPES_SEGMENTS[randI]) {
            case SegmentsConstants.CORRIDOR_SEGMENT -> {
                return new CorridorSegment(mapGame, parent_id);
            }
            case SegmentsConstants.FORK_SEGMENT -> {
                return new ForkSegment(mapGame, parent_id);
            }
        }
        return null; // когда сделаю больше сегментов, здесь будет возвращаться обычный коридор
    }
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.description);
        String playerMessage = sc.nextLine().toLowerCase();
        switch (playerMessage) {
            case "вперёд":
            case "вперед": {
                goForward();
                return;
            }
            case "назад": {
                goBackward();
                return;
            }
        } this.playSegment();
    }
    public void goForward() {
        createRandSegment(mapGame, this.id).playSegment();
    }
    public void goBackward() {
//        int i = mapGame.findNumberOfSegment(this);
//        if (i == 0) {
//            Main.endGame();
//        } else if (i > 0) {
//            System.out.println("НОМЕР СЕГМЕНТА С КОТОРОГО ВЫШЕЛ: " + i);
//            System.out.println("НОМЕР СЕГМЕНТА НА КОТОРЫЙ ПРИШЕЛ: " + (i - 1));
//            mapGame.getSegment(i - 1).playSegment();
//        }
        if (this.id == 0) {
            Main.endGame();
        } else {
            System.out.println("НОМЕР СЕГМЕНТА С КОТОРОГО ВЫШЕЛ: " + this.id);
            System.out.println("НОМЕР СЕГМЕНТА НА КОТОРЫЙ ПРИШЕЛ: " + this.parent_id);
            mapGame.getSegment(this.parent_id).playSegment();
        }
    }
}
