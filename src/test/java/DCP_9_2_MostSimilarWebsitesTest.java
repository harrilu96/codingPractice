import DCP_9_2_MostSimilarWebsites.MostSimilarWebsites;
import DCP_9_2_MostSimilarWebsites.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static DCP_9_2_MostSimilarWebsites.MostSimilarWebsites.MostSimilarWebsites;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DCP_9_2_MostSimilarWebsitesTest {

    @Test
    public void test() {
        List<Pair<String, Integer>> dataList = List.of(
                new Pair<>("1", 1),
                new Pair<>("2", 2),
                new Pair<>("3", 3),
                new Pair<>("4", 4),
                new Pair<>("5", 5),
                new Pair<>("6", 6),
                new Pair<>("7", 7),
                new Pair<>("8", 8),
                new Pair<>("9", 9),
                new Pair<>("10", 10)
        );

        Integer[] expectedHeap = {
                10, 9, 8, 5, 7, 6, 4, 1, null, 3,
                null, 2, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null
        };
        List<Integer> expectedHeapAsList = Arrays.asList(expectedHeap);

        Object[] actualHeap = Arrays.stream(MostSimilarWebsites(dataList).getHeap()).map(e -> e == null ? null : e.getRight()).toArray();
        List<Integer> actualHeapAsList = Arrays.asList(actualHeap).stream().map(e -> (Integer) e).collect(Collectors.toList());

        assertEquals(expectedHeapAsList, actualHeapAsList);
    }

}
