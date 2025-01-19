package inventory_system.items.armors;

public class IronChestplate extends Armor {
    private static final int ARMOR = 10;
    private static final String DESCRIPTION = """
            Железный нагрудник с узором.
            """;
    public IronChestplate() {
        super(ARMOR, DESCRIPTION);
    }
}
