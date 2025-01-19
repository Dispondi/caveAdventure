package inventory_system.items.swords;

public class WoodenSword extends Sword{
    private static final int DAMAGE = 15;
    private static final String DESCRIPTION = """
            Искуссно сделанный деревянный меч.
            """;
    protected WoodenSword() {
        super(DAMAGE, DESCRIPTION);
    }
}
