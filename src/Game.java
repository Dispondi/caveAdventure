public class Game {
    private final int DIFFICULT;
    private final int WAY_LENGTH;
    private final MapGame mapGame;

    public Game(int d, int l) {
        DIFFICULT = d;
        WAY_LENGTH = l;
        mapGame = new MapGame();
    }

    public void start() {
        new CorridorSegment(mapGame).playSegment();
    }
}
