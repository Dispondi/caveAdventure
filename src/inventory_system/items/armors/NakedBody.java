package inventory_system.items.armors;

public class NakedBody extends Armor {
    private static final int ARMOR = 0;
    private static final String DESCRIPTION = """
            Голое тело.
            """;
    public NakedBody() {
        super(ARMOR, DESCRIPTION);
    }
}
