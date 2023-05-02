package DCP_8_2_PrefixSumMap.PrefixMapSum;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private Map<Character, Node> nodeMap;
    private Integer value;
    private Character character;

    public Node(Character character, Integer value) {
        this.character = character;
        this.value = value;
        this.nodeMap = new HashMap<>();
    }

    public Node linkNextNode(Character character, Integer value) {
        Node nextNode = new Node(character, value);
        nodeMap.put(character, nextNode);
        return nextNode;
    }

    public Map<Character, Node> getNodeMap() {
        return this.nodeMap;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
