package segments;

import segmentswork.SegmentsConstants;
import game.*;

import java.util.Scanner;

public class DeadEndSegment extends Segment{
    protected DeadEndSegment(MapGame mapGame, int parent_id, Game game) {
        super(SegmentsConstants.DEADEND_DESCRIPTION, mapGame, parent_id, game);
    }

    @Override
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.description);
        String playerMessage = sc.nextLine().toLowerCase();
        if (playerMessage.equals("назад")) this.goBackward();
        else this.playSegment();
    }
}
