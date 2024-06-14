package org.study;
import java.util.Random;

public class ThirdTaskProbability {
    public static void main(String[] args) {
        int[] player1Sequence = {1, 2, 3};
        int[] player2Sequence = {2, 3, 1};
        int numberOfRolls = 1000;
        int numberOfSimulations = 10000;

        double[] probabilities = simulateGame(player1Sequence, player2Sequence, numberOfRolls, numberOfSimulations);

        System.out.printf("Вероятность победы первого игрока: %.2f%%\n", probabilities[0] * 100);
        System.out.printf("Вероятность победы второго игрока: %.2f%%\n", probabilities[1] * 100);
        System.out.printf("Вероятность ничьи: %.2f%%\n", probabilities[2] * 100);
    }

    public static double[] simulateGame(int[] player1Sequence, int[] player2Sequence, int numberOfRolls, int numberOfSimulations) {
        Random random = new Random();
        int player1Wins = 0;
        int player2Wins = 0;
        int ties = 0;

        for (int i = 0; i < numberOfSimulations; i++) {
            int[] rolls = new int[numberOfRolls];
            for (int j = 0; j < numberOfRolls; j++) {
                rolls[j] = random.nextInt(6) + 1;
            }
            int player1Score = countNonOverlappingOccurrences(rolls, player1Sequence);
            int player2Score = countNonOverlappingOccurrences(rolls, player2Sequence);
            if (player1Score > player2Score) {
                player1Wins++;
            } else if (player2Score > player1Score) {
                player2Wins++;
            } else {
                ties++;
            }
        }

        return new double[] { player1Wins / (double) numberOfSimulations, player2Wins / (double) numberOfSimulations, ties / (double) numberOfSimulations};
    }

    public static int countNonOverlappingOccurrences(int[] sequence, int[] subsequence) {
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
}