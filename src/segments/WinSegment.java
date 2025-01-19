package segments;

import segmentswork.SegmentsConstants;
import game.*;

import java.util.Scanner;

public class WinSegment extends Segment{
    protected WinSegment(MapGame mapGame, int parent_id, Game game) {
        super(SegmentsConstants.WIN_DESCRIPTION, mapGame, parent_id, game);
        game.setWinFoundTrue(); // чтобы не нашелся еще один выход
    }

    @Override
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.description);
        String playerMessage = sc.nextLine().toLowerCase();
        switch (playerMessage) {
            case "да": {
                game.endGame();
                return;
            }
            case "назад": {
                goBackward();
                return;
            }
        } this.playSegment();
    }
}
