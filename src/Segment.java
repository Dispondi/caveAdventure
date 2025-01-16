import support.SupportOperations;
import segmentswork.SegmentsConstants;

import java.util.Scanner;

public class Segment {
    protected MapGame mapGame;
    protected String description;

    protected Segment(String description, MapGame mapGame) {
        this.description = description;
        this.mapGame = mapGame;
        mapGame.addSegment(this);
    }
    private static Segment createRandSegment(MapGame mapGame) {
        int randI = SupportOperations.randInRange(0, SegmentsConstants.ALL_TYPES_SEGMENTS.length - 1);
        switch (SegmentsConstants.ALL_TYPES_SEGMENTS[randI]) {
            case SegmentsConstants.CORRIDOR_SEGMENT -> {
                return new CorridorSegment(mapGame);
            }
        }
        return null; // когда сделаю больше сегментов, здесь будет возвращаться обычный коридор
    }
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.description);
        String playerMessage = sc.nextLine().toLowerCase();
        switch (playerMessage) {
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
        createRandSegment(mapGame).playSegment();
    }
    public void goBackward() {
        int i = mapGame.findNumberOfSegment(this);
        if (i == 0) {
            Main.endGame();
        } else if (i > 0) {
            System.out.println("НОМЕР СЕГМЕНТА: " + i);
            mapGame.getSegment(i - 1).playSegment();
        }
    }
}
