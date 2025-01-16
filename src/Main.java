import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int DIFFICULT = 0;
    public static int WAY_LENGTH = 10;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner sc = new Scanner(System.in);
        printStartMenu();

        String playerMessage = sc.nextLine().toLowerCase();
        switch (playerMessage) {
            case "сложность": {
                changeDifficult();
                return;
            }
            case "длина пути": {
                changeLength();
                return;
            }
            case "нет": {
                endGame();
                return;
            }
            case "да": {
                new Game(DIFFICULT, WAY_LENGTH).start();
                return;
            }
        } start();

    }

    private static void printStartMenu() {
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Настройки игры:");
        System.out.println("Сложность: " + DIFFICULT + "/10");
        System.out.println("Длина пути: " + WAY_LENGTH);
        System.out.println("Для изменения настроек, введите пункт, который хотите изменить.");
        System.out.println("----------------\n");
        System.out.println("Перед собой вы видите заброшенный вход в пещеру, желаете ли войти?\nДа/Нет");
    }

    private static void changeDifficult() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сложность до 10:");

        int playerMessage;
        try {
            playerMessage = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод!");
            start();
            return;
        }

        DIFFICULT = Math.min(playerMessage, 10);
        start();
    }

    private static void changeLength() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину пути. Вам нужно будет пройти столько клеток, чтобы добраться до выхода");

        int playerMessage;
        try {
            playerMessage = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод!");
            start();
            return;
        }

        WAY_LENGTH = playerMessage;
        start();
    }
    public static void endGame() {
        System.out.println("Вы вышли из подземелья. Конец.");
    }
}