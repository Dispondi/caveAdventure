import segmentswork.SegmentsConstants;

import java.util.Scanner;

public class WinSegment extends Segment{
    protected WinSegment(MapGame mapGame, int parent_id) {
        super(SegmentsConstants.WIN_DESCRIPTION, mapGame, parent_id);
    }

    @Override
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.description);
        String playerMessage = sc.nextLine().toLowerCase();
        switch (playerMessage) {
            case "да": {
                Game.endGame();
                return;
            }
            case "назад": {
                goBackward();
                return;
            }
        } this.playSegment();
    }
}
