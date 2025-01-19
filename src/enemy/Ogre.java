package enemy;

import game.Game;

public class Ogre extends Enemy{
    private static final int DAMAGE = 10;
    private static final int HEALTH = 30;
    private static final int POINTS = 500;
    private static final String DESCRIPTION = """
            -----------------
            Огромный свирепый огр стоит перед вами. Кажется вы будете его сегодняшним обедом.
            -Драться/Убежать
            -----------------
            """;

    public Ogre(Game game) {
        super(DAMAGE, HEALTH, POINTS, DESCRIPTION, game);
    }
}
