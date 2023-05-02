package DCP_3_2_AddingLinkedLists;

public class AddLinkedLists {

    public static Node Add(Integer a, Integer b) {
        Node nodeA = new Node(a, false);
        Node nodeB = new Node(b, false);
        Node sumInit = new Node();
        Node currentNode = sumInit;
        boolean carry = false;
        while (nodeA.hasNext() || nodeB.hasNext()) {
            Integer sum = zeroIfNull(nodeA.getValue()) + zeroIfNull(nodeB.getValue());
            if (carry) {
                sum += 1;
                carry = false;
            }
            if (sum > 9) {
                carry = true;
                sum -=10;
            }
            currentNode.setValue(sum);
            Node nextNode = new Node();
            currentNode.setNext(nextNode);
            currentNode = currentNode.getNext();
            if (nodeA.hasNext()) nodeA = nodeA.getNext();
            if (nodeB.hasNext()) nodeB = nodeB.getNext();
        }
        if (carry) {
            currentNode.setValue(1);
        } else currentNode.setValue(0);

        return sumInit;
    }

    private static int zeroIfNull(Integer value) {
        return value == null ? 0 : value;
    }
}
