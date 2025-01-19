package segments;

import inventory_system.items.armors.Armor;
import inventory_system.items.swords.Sword;
import segments.segmentswork.SegmentsTextConstants;
import support.SupportOperations;
import game.*;

import java.util.Objects;
import java.util.Scanner;

public class TreasureCorridorSegment extends Segment{
    private boolean isEmpty;
    private final boolean isMimic;
    private static final String[] DROP = new String[] {"p", "s", "a"}; // points, sword, armor

    protected TreasureCorridorSegment(MapGame mapGame, int parent_id, Game game) {
        super(SegmentsTextConstants.TREASURE_CORRIDOR_DESCRIPTION, mapGame, parent_id, game);
        isEmpty = false;
        isMimic = SupportOperations.randInRange(1, 100) <= SegmentsTextConstants.MIMIC_PERCENT; // % of be mimic
        //System.out.println("MIMIC = " + isMimic); // for devs
    }

    @Override
    public void playSegment() {
        Scanner sc = new Scanner(System.in);
        System.out.print(this.description);
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
                takeRandItem();
                return;
            }
        } this.playSegment();
    }

    private void takeRandItem() {
        if (isMimic) {
            System.out.println("Вы прикасаетесь к шкатулке и огромная пасть заглатывает вас внутрь. Вы мертвы.");
            game.endGame();
            return;
        }
        if (!isEmpty) {
            isEmpty = true;
            itemDropLogic(SupportOperations.takeRandObjectFromArray(DROP));
            game.player.givePoints(50);
            this.description = SegmentsTextConstants.TREASURE_EMPTY_CORRIDOR_DESCRIPTION;
            this.playSegment();
        }
    }

    private void itemDropLogic(String arg) {
        switch (arg) {
            case "p": {
                System.out.println("Вы подобрали шкатулку, внтури вы нашли золото. Вы получили 200 очков.");
                game.player.givePoints(200);
                return;
            }
            case "s": {
                Sword sword = Objects.requireNonNull(Sword.giveRandomSword());
                System.out.println("Вы подобрали шкатулку, ваш прошлый клинок рассыпается у вас в руке. Внутри шкатулки вы нашли и экипировали меч:");
                System.out.println(sword.description + "\nУрон: " + sword.DAMAGE);
                game.player.inventory.setSword(sword);
                return;
            }
            case "a": {
                Armor armor = Objects.requireNonNull(Armor.giveRandomArmor());
                System.out.println("Вы подобрали шкатулку, ваш доспех распадается на сотни частиц. Внутри шкатулки вы нашли и экипировали броню:");
                System.out.println(armor.description + "\nЗащита: " + armor.ARMOR);
                game.player.inventory.setArmor(armor);
            }
        }
    }
}
