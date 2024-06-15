package org.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondTaskTest {

    @Test
    public void findMostFrequentNumbersTest(){
        int[] testSec = new int[]{5, 7, 5, 9, 3, 1, 9, 8, 6, 6, 1, 7, 4, 5, 7, 5, 7, 5, 1, 4};
        Assertions.assertArrayEquals(SecondTask.findMostFrequentNumbers(testSec), new int[]{5});
    }
}
