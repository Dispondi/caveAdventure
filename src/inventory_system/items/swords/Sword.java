package inventory_system.items.swords;

import support.SupportOperations;

public abstract class Sword {
    private static final String[] SWORDS_LIST = new String[] {"irSw", "wSw"};
    public final int DAMAGE;
    public String description;

    protected Sword(int damage, String description) {
        DAMAGE = damage;
        this.description = description;
    }

    public static Sword giveRandomSword() {
        String sw = SupportOperations.takeRandObjectFromArray(SWORDS_LIST);
        return switch (sw) {
            case "irSw" -> new IronSword();
            case "wSw" -> new WoodenSword();
            default -> null;
        };
    }
}
