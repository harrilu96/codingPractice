import DCP_8_2_PrefixSumMap.PrefixMapSum.PrefixMapSum;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {

        // DCP8.2 Prefix Sum Map Test
        PrefixMapSum mapsum = new PrefixMapSum();

        mapsum.insert("colander", 1);
        mapsum.insert("column", 2);
        mapsum.insert("collusion", 3);
        mapsum.insert("arterial", 5);
        mapsum.insert("art", 7);

        assertEquals(6, mapsum.sum("col"));
        assertEquals(3, mapsum.sum("coll"));
        assertEquals(5, mapsum.sum("arterial"));
        assertEquals(12, mapsum.sum("art"));

        mapsum.insert("arte", 11);

        assertEquals(23, mapsum.sum("art"));

    }
}
