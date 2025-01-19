package inventory_system.items.swords;

public class Hands extends Sword{
    private static final int DAMAGE = 10;
    private static final String DESCRIPTION = """
            Голые кулаки.
            """;
    public Hands() {
        super(DAMAGE, DESCRIPTION);
    }
}
