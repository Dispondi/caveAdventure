package inventory_system.items.swords;

public class IronSword extends Sword{
    private static final int DAMAGE = 25;
    private static final String DESCRIPTION = """
            Железный меч с удобной гардой.
            """;
    public IronSword() {
        super(DAMAGE, DESCRIPTION);
    }
}
