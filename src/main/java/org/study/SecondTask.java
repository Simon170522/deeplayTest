package org.study;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SecondTask {
    public static void main(String[] args) {
        int n = 20; // размер массива 4
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10) + 1; // заполнение числами от 1 до 2 для примера
        }
        System.out.println("Исходный массив:");
        printArray(array);
        int[] mostFrequentNumbers = findMostFrequentNumbers(array);
        System.out.println("Наиболее часто встречающиеся числа:");
        printArray(mostFrequentNumbers);
    }
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static int[] findMostFrequentNumbers(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }
        int count = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == maxFrequency) {
                count++;
            }
        }
        int[] mostFrequentNumbers = new int[count];
        int index = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == maxFrequency) {
                mostFrequentNumbers[index++] = key;
            }
        }

        return mostFrequentNumbers;
    }
}
