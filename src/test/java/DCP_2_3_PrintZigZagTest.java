import org.junit.jupiter.api.Test;

import static DCP_2_3_PrintZigZag.PrintZigZag.PrintZigZag;

public class DCP_2_3_PrintZigZagTest {

    @Test
    public void happyPath() {
        PrintZigZag("hellothisisatest", 4);
    }

    @Test
    public void printOneRow() {
        PrintZigZag("totoroisawesome", 1);
    }

    @Test
    public void printWithSpaces() {
        PrintZigZag("asdkfjawlef alkdjfh alkwfh askdf h", 3);
    }

    @Test
    public void printMoreRowsThanLetters() {
        PrintZigZag("apple", 10);
    }
}
