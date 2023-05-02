package DCP_3_2_AddingLinkedLists;

public class Node {
    private Integer value;
    private Node next;

    public Node(Integer value, boolean isSingleDigit) {
        if (isSingleDigit) {
            this.value = value;
        } else {
            String numberAsString = value.toString();
            String reversedString = new StringBuilder(numberAsString).reverse().toString();
            this.value = Integer.parseInt(String.valueOf(reversedString.charAt(0)));
            Node currentNode = this;
            for (int i = 1; i < reversedString.length(); i++) {
                Node nextNode = new Node(Integer.parseInt(String.valueOf(reversedString.charAt(i))), true);
                currentNode.next = nextNode;
                currentNode = nextNode;
            }
            currentNode.next = new Node(0, true);
        }
    }

    public int nodeToInt() {
        Node currentNode = this;
        StringBuilder stringbuilder = new StringBuilder();
        while (currentNode.hasNext()) {
            stringbuilder.append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return Integer.parseInt(stringbuilder.reverse().toString());
    }

    public Node(){};

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean hasNext() {
        return !(this.next == null);
    }
}
