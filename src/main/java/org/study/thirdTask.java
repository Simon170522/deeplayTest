package org.study;

public class thirdTask {
    public static void main(String[] args) {
        ThirdTaskGame game = new ThirdTaskGame();
        int[] gameNumbers = game.getGameList();
        System.out.println("Игровая последовательность:");
        for (int num: gameNumbers){
            System.out.printf("%d ", num);
        }
        System.out.println();
        int[] results = game.getPlayerResult();
        System.out.printf("Первый игрок получил %d",results[0]);
        System.out.println();
        System.out.printf("Второй игрок получил %d",results[1]);
    }
}
