package DCP_16_2_BellmanFord;

import java.util.HashMap;
import java.util.Map;

public class Node implements Comparable<Node>{
    public Integer id;
    public Map<Node, Integer> edges;

    public Node(Integer id, Map<Node, Integer> edges) {
        this.id = id;
        this.edges = edges;
    }

    public Node(Integer id) {
        this.id = id;
        this.edges = new HashMap<>();
    }

    public void putEdge(Node node, Integer weight) {
        if (edges.containsKey(node)) {
            throw new RuntimeException("Node already exists");
        } else {
            edges.put(node, weight);
        }
    }

    public Map<Node, Integer> getEdges() {
        return this.edges;
    }

    @Override
    public int compareTo(Node o) {
        if (this.id == o.id) {
            return 0;
        } else if (this.id > o.id) {
            return 1;
        } else {
            return -1;
        }
    }
}
