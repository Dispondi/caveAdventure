import segmentswork.SegmentsConstants;

import java.util.Scanner;

public class CorridorSegment extends Segment {
    public CorridorSegment(MapGame mapGame, int parent_id, Game game) {
        super(SegmentsConstants.CORRIDOR_DESCRIPTION, mapGame, parent_id, game);
    }

    @Override
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
}
