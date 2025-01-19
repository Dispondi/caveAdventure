package inventory_system.items.armors;

import support.SupportOperations;

public abstract class Armor {
    private static final String[] ARMOR_LIST = new String[] {"leCh", "irCh"};
    public final int ARMOR;
    public String description;

    protected Armor(int armor, String description) {
        ARMOR = armor;
        this.description = description;
    }
    public static Armor giveRandomArmor() {
        String sw = SupportOperations.takeRandObjectFromArray(ARMOR_LIST);
        return switch (sw) {
            case "leCh" -> new LeatherChestplate();
            case "irCh" -> new IronChestplate();
            default -> null;
        };
    }
}
