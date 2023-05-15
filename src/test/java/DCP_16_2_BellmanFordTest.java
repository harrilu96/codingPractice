import DCP_16_2_BellmanFord.BellmanFordAlgo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static DCP_16_2_BellmanFord.BellmanFordAlgo.BellmanFord;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DCP_16_2_BellmanFordTest {

    @Test
    public void testNonNegativeCycle() {
        List<List<Integer>> graphDef = List.of(
                List.of(1,2,-1),
                List.of(1,5,4),
                List.of(2,3,2),
                List.of(2,5,3),
                List.of(2,4,2),
                List.of(3,4,-3),
                List.of(4,2,1),
                List.of(4,5,5)
        );

        Map<Integer, Integer> expectedDistanceMap = Map.of(
                1,0,
                2,-1,
                3,1,
                4,-2,
                5,2
        );

        assertEquals(expectedDistanceMap, BellmanFord(graphDef, 1));
    }

    @Test
    public void testNegativeCycle() {
        List<List<Integer>> graphDef = List.of(
                List.of(1,2,-1),
                List.of(1,5,4),
                List.of(2,3,2),
                List.of(2,5,3),
                List.of(2,4,2),
                List.of(3,4,-3),
                List.of(4,2,-5),
                List.of(4,5,5)
        );

        assertThrows(RuntimeException.class, () -> BellmanFord(graphDef, 1));
    }
}
