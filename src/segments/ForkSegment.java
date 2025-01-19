package segments;

import segments.segmentswork.SegmentsTextConstants;
import support.SupportOperations;
import game.*;

import java.util.Scanner;

public class ForkSegment extends Segment {
    private final int corridorsAmount;

    protected ForkSegment(MapGame mapGame, int parent_id, Game game) {
        super(SegmentsTextConstants.FORK_DESCRIPTION, mapGame, parent_id, game);
        corridorsAmount = SupportOperations.randInRange(2,3);
    }

    @Override
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        String playerMessage;
        switch (corridorsAmount) {
            case 2: {
                System.out.println(this.description + SegmentsTextConstants.DOUBLE_FORK_OFFER); // description
                playerMessage = sc.nextLine().toLowerCase();
                switch (playerMessage) {
                    case "назад": {
                        this.goBackward();
                        return;
                    }
                    case "левую": {
                        this.goForward(1);
                        return;
                    }
                    case "правую": {
                        this.goForward(2);
                        return;
                    }
                } this.playSegment();
            }
            case 3: {
                System.out.println(this.description + SegmentsTextConstants.TRIPLE_FORK_OFFER); // description
                playerMessage = sc.nextLine().toLowerCase();
                switch (playerMessage) {
                    case "назад": {
                        this.goBackward();
                        return;
                    }
                    case "левую": {
                        this.goForward(1);
                        return;
                    }
                    case "среднюю": {
                        this.goForward(0);
                        return;
                    }
                    case "правую": {
                        this.goForward(2);
                        return;
                    }
                } this.playSegment();
            }
        }
    }
}
