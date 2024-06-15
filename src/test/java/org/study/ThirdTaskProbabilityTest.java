package org.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdTaskProbabilityTest {
    @Test
    public void countNonOverlappingOccurrencesTest(){
        int[] testSec = new int[]{3, 4, 6, 5, 6, 2, 2, 5, 1, 1, 2, 2, 2, 4, 2, 1, 6, 1, 4, 1};
        Assertions.assertEquals(ThirdTaskProbability.countNonOverlappingOccurrences(
                testSec, new int[]{4, 5, 4}),
                0);
    }

    @Test
    public void simulateGameTest(){
        Assertions.assertDoesNotThrow(() -> ThirdTaskProbability.simulateGame(
                        new int[]{1, 1, 1},
                        new int[]{1, 5, 1},
                        10,
                        50));
    }
}
