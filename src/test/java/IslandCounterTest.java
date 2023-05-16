import org.junit.jupiter.api.Test;

import static NumIslands.IslandCounter.CountIslands;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandCounterTest {

    @Test
    public void TestIslandCounter1() {
        int[][] mapToTest = {
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };

        assertEquals(2, CountIslands(mapToTest));
    }

    @Test
    public void TestIslandCounter2() {
        int[][] mapToTest = new int[0][0];

        assertEquals(2, CountIslands(mapToTest));
    }

    @Test
    public void TestIslandCounter3() {
        int[][] mapToTest = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        assertEquals(1, CountIslands(mapToTest));
    }

    @Test
    public void TestIslandCounter4() {
        int[][] mapToTest = {
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };

        assertEquals(13, CountIslands(mapToTest));
    }

    @Test
    public void TestIslandCounter5() {
        int[][] mapToTest = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        assertEquals(0, CountIslands(mapToTest));
    }
}
