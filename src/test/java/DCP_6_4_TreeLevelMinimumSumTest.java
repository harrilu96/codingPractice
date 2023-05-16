import DCP_6_4_TreeLevelMinimumSum.Node;
import org.junit.jupiter.api.Test;

import static DCP_6_4_TreeLevelMinimumSum.MinimumSum.MinimumSum;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DCP_6_4_TreeLevelMinimumSumTest {

    @Test
    public void test() {
        /*
              1
             / \
            2   3
               / \
              4   5
         */
        Node root = new Node(1);
        Node subtree1 = new Node(3);
        subtree1.assignChildren(new Node(4), new Node(5));
        root.assignChildren(new Node(2), subtree1);

        assertEquals(0, MinimumSum(root));
    }

    @Test
    public void test1() {
        /*
              1
             / \
            2   -3
               / \
              4   5
         */
        Node root = new Node(1);
        Node subtree1 = new Node(-3);
        subtree1.assignChildren(new Node(4), new Node(5));
        root.assignChildren(new Node(2), subtree1);

        assertEquals(1, MinimumSum(root));
    }

}
