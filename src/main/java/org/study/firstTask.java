package org.study;

import java.util.*;

public class firstTask {
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
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> otherNumbers = new ArrayList<>();

        for (int num : array) {
            if (num % 2 != 0) {
                oddNumbers.add(num);
            } else if (num == 0) {
                zeros.add(num);
            } else {
                otherNumbers.add(num);
            }
        }

        Collections.sort(oddNumbers);
        otherNumbers.sort(Collections.reverseOrder());

        int[] result = new int[array.length];
        int index = 0;

        for (int num : oddNumbers) {
            result[index++] = num;
        }
        for (int num : zeros) {
            result[index++] = num;
        }
        for (int num : otherNumbers) {
            result[index++] = num;
        }

        return result;
    }
}
