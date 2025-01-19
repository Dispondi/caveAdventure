package segments;

import segmentswork.SegmentsConstants;
import support.SupportOperations;
import game.*;

import java.util.Scanner;

public class TreasureCorridorSegment extends Segment{
    private boolean isEmpty;
    private final boolean isMimic;

    protected TreasureCorridorSegment(MapGame mapGame, int parent_id, Game game) {
        super(SegmentsConstants.TREASURE_CORRIDOR_DESCRIPTION, mapGame, parent_id, game);
        isEmpty = false;
        isMimic = SupportOperations.randInRange(1, 100) <= SegmentsConstants.MIMIC_PERCENT; // % of be mimic
        System.out.println("MIMIC = " + isMimic);
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
            case "подобрать": {
                if (isMimic) {
                    System.out.println("Вы прикасаетесь к шкатулке и огромная пасть заглатывает вас внутрь. Вы мертвы.");
                    game.endGame();
                    return;
                }
                if (!isEmpty) {
                    isEmpty = true;
                    System.out.println("Вы подобрали шкатулку. Вы получили 200 очков.");
                    this.description = SegmentsConstants.TREASURE_EMPTY_CORRIDOR_DESCRIPTION;
                    this.playSegment();
                    return;
                }
            }
        } this.playSegment();
    }
}
