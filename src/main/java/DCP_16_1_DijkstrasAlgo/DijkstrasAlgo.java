package DCP_16_1_DijkstrasAlgo;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstrasAlgo {

    public static Map<Integer, Node> createNodeMap(List<List<Integer>> mapDef) {
        Map<Integer, Node> map = new HashMap<>();

        for (List<Integer> nodeDef : mapDef) {
            if (!map.containsKey(nodeDef.get(0))) {
                map.put(nodeDef.get(0), new Node(nodeDef.get(0)));
            }
            if (!map.containsKey(nodeDef.get(1))) {
                map.put(nodeDef.get(1), new Node(nodeDef.get(1)));
            }
            map.get(nodeDef.get(0)).putEdge(map.get(nodeDef.get(1)), nodeDef.get(2));
        }

        return map;
    }

    public static int returnLongestShortPath(List<List<Integer>> mapDef, Integer startingPoint) {
        Map<Integer, Node> map = createNodeMap(mapDef);            // Map NodeId: Node
        Map<Integer, Integer> distanceMap = map.keySet().stream()  // Map NodeId: distance to NodeId from startingPoint
                .collect(Collectors.toMap(e -> e, e -> Integer.MAX_VALUE));
        distanceMap.put(startingPoint, 0);

        Queue<Node> nodesToVisit = new PriorityQueue<>();
        nodesToVisit.add(map.get(startingPoint));

        while(!nodesToVisit.isEmpty()) {
            Node currentNode = nodesToVisit.poll();
            for (Node destNode : currentNode.getEdges().keySet()) {
                Integer weight = currentNode.getEdges().get(destNode);
                Integer totalWeight = distanceMap.get(currentNode.id) + weight;
                if (distanceMap.get(destNode.id) == Integer.MAX_VALUE) {
                    nodesToVisit.add(destNode);
                }
                if (totalWeight < distanceMap.get(destNode.id)) {
                    distanceMap.put(destNode.id, totalWeight);
                }
            }
        }

        Integer maxValue = 0;
        for (Integer value : distanceMap.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
