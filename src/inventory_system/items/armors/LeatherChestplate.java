package inventory_system.items.armors;

public class LeatherChestplate extends Armor{
    private static final int ARMOR = 3;
    private static final String DESCRIPTION = """
            Кожаные ошметки, издалека напоминающие очертания брони.
            """;
    public LeatherChestplate() {
        super(ARMOR, DESCRIPTION);
    }
}
