package segments;

import segments.segmentswork.SegmentsTextConstants;
import game.*;

import java.util.Scanner;

public class CorridorSegment extends Segment {
    Scanner sc = new Scanner(System.in);
    public CorridorSegment(MapGame mapGame, int parent_id, Game game) {
        super(SegmentsTextConstants.CORRIDOR_DESCRIPTION, mapGame, parent_id, game);
    }

    @Override
    public void playSegment() {
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
}
