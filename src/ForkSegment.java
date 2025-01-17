import segmentswork.SegmentsConstants;
import support.SupportOperations;

import java.util.Scanner;

public class ForkSegment extends Segment {
    private final int corridorsAmount;

    protected ForkSegment(MapGame mapGame, int parent_id) {
        super(SegmentsConstants.FORK_DESCRIPTION, mapGame, parent_id);
        corridorsAmount = SupportOperations.randInRange(2,3);
    }

    @Override
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this.description);
        String playerMessage;
        switch (corridorsAmount) {
            case 2: {
                System.out.println(SegmentsConstants.DOUBLE_FORK_OFFER);
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
                System.out.println(SegmentsConstants.TRIPLE_FORK_OFFER);
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
                    }
                    case "правую": {
                        this.goForward(2);
                    }
                } this.playSegment();
            }
        }
    }
}
