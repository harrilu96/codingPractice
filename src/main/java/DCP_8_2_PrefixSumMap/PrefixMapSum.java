package DCP_8_2_PrefixSumMap;

import java.util.HashMap;
import java.util.Map;

public class PrefixMapSum {

    private Map<Character, Node> startingNodes;

    public PrefixMapSum(){
        startingNodes = new HashMap<>();
    };

    public void insert(String key, int value) {
        if(startingNodes.containsKey(key.charAt(0))) {
            Node startingNode = startingNodes.get(key.charAt(0));
            if (key.length() == 1) {
                if (startingNodes.get(key.charAt(0)).getValue() != null) {
                    throw new RuntimeException("not null");
                } else {
                    startingNodes.get(key.charAt(0)).setValue(value);
                }
            } else {
                Node nextNode = startingNode;
                for (int i = 1; i < key.length(); i++) {
                    if (nextNode.getNodeMap().containsKey(key.charAt(i))) {
                        nextNode = nextNode.getNodeMap().get(key.charAt(i));
                        if (i == key.length() - 1) {
                            nextNode.setValue(value);
                        }
                    } else {
                        char nextChar = key.charAt(i);
                        nextNode = nextNode.linkNextNode(nextChar, i == key.length()-1 ? value : null);
                    }
                }
            }
        } else {
            if (key.length() == 1) {
                Node startingNode = new Node(key.charAt(0), value);
                startingNodes.put(key.charAt(0), startingNode);
            }
            else {
                Node startingNode = new Node(key.charAt(0), null);
                startingNodes.put(key.charAt(0), startingNode);
                Node nextNode = startingNode;
                for (int i = 1; i < key.length(); i++) {
                    nextNode = nextNode.linkNextNode(key.charAt(i), i == key.length()-1 ? value : null);
                }
            }
        }
    }

    public int sum(String prefix) {
        Node nextNode = this.startingNodes.get(prefix.charAt(0));
        for (int i = 1; i < prefix.length(); i++) {
            if (!nextNode.getNodeMap().containsKey(prefix.charAt(i))) {
                throw new RuntimeException("does not contain key");
            }
            nextNode = nextNode.getNodeMap().get(prefix.charAt(i));
        }
        return dfsSum(nextNode);
    }

    private Integer dfsSum(Node node) {

        Integer sum = 0;
        sum += (node.getValue() == null ? 0 : node.getValue());
        if (node.getNodeMap().isEmpty()) {
            if (node.getValue() == null) {
                throw new RuntimeException("terminal node value is null");
            } else {
                return sum;
            }
        } else {
            for (Node nodeMapValue : node.getNodeMap().values()) {
                sum += dfsSum(nodeMapValue);
            }
            return sum;
        }
    }

}
