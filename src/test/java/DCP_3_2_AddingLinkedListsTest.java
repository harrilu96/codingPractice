import DCP_3_2_AddingLinkedLists.AddLinkedLists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DCP_3_2_AddingLinkedListsTest {

    @Test
    public void test() {
        Assertions.assertEquals(31, AddLinkedLists.Add(16, 15).nodeToInt());
        assertEquals(7, AddLinkedLists.Add(2,5).nodeToInt());
        assertEquals(131, AddLinkedLists.Add(115, 16).nodeToInt());
        assertEquals(1310, AddLinkedLists.Add(10, 1300).nodeToInt());
    }

}
