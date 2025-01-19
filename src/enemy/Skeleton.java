package enemy;

import game.Game;

public class Skeleton extends Enemy{
    private static final int DAMAGE = 5;
    private static final int HEALTH = 15;
    private static final int POINTS = 200;
    private static final String DESCRIPTION = """
            -----------------
            Перед вами скелет. Нежить настроена агрессивно, что вы будете делать?
            -Драться/Убежать
            -----------------
            """;

    public Skeleton(Game game) {
        super(DAMAGE, HEALTH, POINTS, DESCRIPTION, game);
    }
}
