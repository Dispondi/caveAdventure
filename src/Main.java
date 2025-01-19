import game.Game;

public class Main {
    private static final int DIFFICULT = 5;
    private static final int WAY_LENGTH = 10;

    public static void main(String[] args) {
        Game game = new Game(DIFFICULT, WAY_LENGTH);
        game.startMenu();
    }
}