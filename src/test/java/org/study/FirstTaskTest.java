package org.study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class FirstTaskTest {

    @Test
    public void reorderArrayTest(){
        int[] testSec = new int[]{8, 5, -7, -8, -7, 7, -1, 8, 7, 0, 1, 3, -1, -1, -3, -5, 6, -7, -1, 0};
        int[] trueSec = new int[]{-7, -7, -7, -5, -3, -1, -1, -1, -1, 1, 3, 5, 7, 7, 0, 0, 8, 8, 6, -8};
        Assertions.assertArrayEquals(FirstTask.reorderArray(testSec), trueSec);
    }
}
