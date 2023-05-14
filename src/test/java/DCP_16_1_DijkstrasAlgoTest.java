import org.junit.jupiter.api.Test;

import java.util.List;

import static DCP_16_1_DijkstrasAlgo.DijkstrasAlgo.returnLongestShortPath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DCP_16_1_DijkstrasAlgoTest {

    @Test
    public void test() {
        List<List<Integer>> mapDef = List.of(
                List.of(0,1,5),
                List.of(0,2,3),
                List.of(0,5,4),
                List.of(1,3,8),
                List.of(2,3,1),
                List.of(3,5,10),
                List.of(3,4,5)
        );
        assertEquals(9, returnLongestShortPath(mapDef, 0));
    }
}
