package game;

import player.Player;
import segments.CorridorSegment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private int DIFFICULT;
    private int WAY_LENGTH;
    private boolean isWinFound;
    private final MapGame mapGame;
    public final Player player;

    public Game(int d, int l, Player player) {
        DIFFICULT = d;
        WAY_LENGTH = l;
        this.player = player;
        isWinFound = false;
        mapGame = new MapGame();
    }

    public void setWinFoundTrue() {
        isWinFound = true;
    }

    public boolean isWinFound() {
        return isWinFound;
    }

    public int getDIFFICULT() {
        return DIFFICULT;
    }

    public int getWAY_LENGTH() {
        return WAY_LENGTH;
    }

    private void start() {
        new CorridorSegment(mapGame, mapGame.segmentID, this).playSegment();
    }

    private void printStartMenu() {
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Настройки игры:");
        System.out.println("Сложность: " + DIFFICULT + "/10");
        System.out.println("Длина пути: " + WAY_LENGTH);
        System.out.println("Для изменения настроек, введите пункт, который хотите изменить.");
        System.out.println("----------------\n");
        System.out.println("Перед собой вы видите заброшенный вход в пещеру, желаете ли войти?\nДа/Нет");
    }

    public void startMenu() {
        this.printStartMenu();

        Scanner sc = new Scanner(System.in);
        String playerMessage = sc.nextLine().toLowerCase();
        switch (playerMessage) {
            case "сложность": {
                this.changeDifficult();
                return;
            }
            case "длина пути": {
                this.changeLength();
                return;
            }
            case "нет": {
                endGame();
                return;
            }
            case "да": {
                this.start();
                return;
            }
        } startMenu();
    }

    private void changeDifficult() {
        System.out.println("Введите сложность от 1 до 10:");

        Scanner sc = new Scanner(System.in);
        int playerMessage;
        try {
            playerMessage = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод!");
            changeDifficult();
            return;
        }

        DIFFICULT = Math.min(Math.abs(playerMessage), 10);
        DIFFICULT = Math.max(1, DIFFICULT); // difficult = 0 => difficult = 1;
        startMenu();
    }

    private void changeLength() {
        System.out.println("Введите длину пути. Вам нужно будет пройти столько клеток, чтобы добраться до выхода");

        Scanner sc = new Scanner(System.in);
        int playerMessage;
        try {
            playerMessage = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод!");
            changeLength();
            return;
        }

        WAY_LENGTH = Math.abs(playerMessage);
        startMenu();
    }
    public void endGame() {
        System.out.println("Конец.");
        System.out.println("Очки: " + player.getPoints());
    }
}
