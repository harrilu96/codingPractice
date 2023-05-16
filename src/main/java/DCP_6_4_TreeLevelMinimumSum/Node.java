package DCP_6_4_TreeLevelMinimumSum;

public class Node {
    private Integer value;
    private Node left;
    private Node right;

    public Node(Integer value) {
        this.value = value;
    }

    public void assignChildren(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public Integer getValue() {
        return this.value;
    }
}
