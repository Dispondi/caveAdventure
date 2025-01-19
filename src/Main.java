import game.Game;
import inventory_system.Inventory;
import player.Player;

public class Main {
    private static final int DIFFICULT = 5;
    private static final int WAY_LENGTH = 10;

    public static void main(String[] args) {
        Player player = new Player(new Inventory());
        Game game = new Game(DIFFICULT, WAY_LENGTH, player);
        game.startMenu();
    }
}