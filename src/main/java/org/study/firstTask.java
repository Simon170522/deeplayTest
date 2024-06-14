package org.study;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 20;
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(21) - 10; // Заполнение числами от -10 до 10
        }
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));
        int[] sortedArray = reorderArray(array);
        System.out.println("Переупорядоченный массив:");
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] reorderArray(int[] array) {
        int[] oddNumbers = Arrays.stream(array).filter(x -> x % 2 != 0).sorted().toArray();
        int[] zeros = Arrays.stream(array).filter(x -> x == 0).toArray();
        int[] otherNumbers = Arrays.stream(array).filter(x -> x % 2 == 0 && x != 0).boxed()
                .sorted((a, b) -> b - a).mapToInt(i -> i).toArray();

        int[] result = new int[array.length];
        int index = 0;

        for (int num : oddNumbers) {
            result[index++] = num;
        }

        for (int num : zeros) {
            result[index++] = num;
        }

        // Затем остальные числа по не возрастанию
        for (int num : otherNumbers) {
            result[index++] = num;
        }

        return result;
    }
}
