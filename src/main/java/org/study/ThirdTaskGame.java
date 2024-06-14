package org.study;

import java.util.Random;
import java.util.Scanner;

public class ThirdTaskGame {
    private final int[][] playerTriple;
    private final Scanner scanner;
    private int numberOfThrows;
    private final int[] playerResult;
    private final int[] gameList;
    public ThirdTaskGame(){
        this.scanner = new Scanner(System.in);
        this.playerTriple = new int[2][3];
        this.playerResult = new int[2];
        this.setPlayerTriple(0);
        this.setPlayerTriple(1);
        this.setNumberOfThrows();
        this.gameList = new int[this.numberOfThrows];
        this.rollDice();
    }

    public void rollDice(){
        Random rand = new Random();
        for (int i = 0; i < this.numberOfThrows; i++) {
            this.gameList[i] = rand.nextInt(6) + 1; // заполнение числами от 1 до 2 для примера
        }
    }
    private void makeResults(){
        this.playerResult[0] = countSubsequenceOccurrences(gameList, playerTriple[0]);
        this.playerResult[1] = countSubsequenceOccurrences(gameList, playerTriple[1]);
    }
    private int countSubsequenceOccurrences(int[] sequence, int[] subsequence) {
        if (subsequence.length == 0) return 0;
        int count = 0;
        int i = 0;
        while (i <= sequence.length - subsequence.length) {
            boolean match = true;
            for (int j = 0; j < subsequence.length; j++) {
                if (sequence[i + j] != subsequence[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
                i += subsequence.length;
            } else {
                i++;
            }
        }
        return count;
    }
    public int[] getPlayerResult() {
        this.makeResults();
        return playerResult;
    }

    public int[] getGameList() {
        return gameList;
    }

    private void setPlayerTriple(int playerId) {
        System.out.printf("Выберите числа %d игрока", playerId + 1);
        for(int i = 0; i < 3; i++){
            this.playerTriple[playerId][i] = scanner.nextInt();
        }
    }

    private void setNumberOfThrows(){
        System.out.println("Введите кол-во бросков");
        this.numberOfThrows = scanner.nextInt();
    }
}
