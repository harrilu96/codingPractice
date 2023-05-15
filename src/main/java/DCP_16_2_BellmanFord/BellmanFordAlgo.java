package DCP_16_2_BellmanFord;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BellmanFordAlgo {
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

    /*
    This implementation is not exactly what is written in the book as the book's question also tests your ability
    to do some clever mathing to get decimals into negative numbers that correlate to edge weights. I think that testing
    conceptual ideas are more important than getting that "clever math trick", so I'll do a simple bellman-ford
    algo below, and simply explain the solution to the original problem described via text.

    The exchange rate between two currencies is calculated via multiplication. However, bellman ford algo only works with
    adding edges together. Therefore, we can use logarithms to turn this problem from a multiplicative to an additive one.
    log(a x b) = log(a) + log(b). So, if we take the logarithm of each exchange rate, and negate it to ensure that weights
    are positive, we can transform this problem into one of finding a negative sum cycle. If one is detected, then we know
    that there is an arbitrage.
     */

    public static Map<Integer, Integer> BellmanFord(List<List<Integer>> mapDef, Integer startingPoint) {
        Map<Integer, Node> map = createNodeMap(mapDef);            // Map NodeId: Node
        Map<Integer, Integer> distanceMap = map.keySet().stream()  // Map NodeId: distance to NodeId from startingPoint
                .collect(Collectors.toMap(e -> e, e -> Integer.MAX_VALUE));
        distanceMap.put(startingPoint, 0);

        /*
        Relax all edges V-1 times, where V is number of vertices. Longest distance to an edge (with no cycles) will have
        v-1 edges. Cycles will be detected later on.
         */

        for(int i = 0; i < map.size(); i++) {
            for (List<Integer> edge : mapDef) {
                Integer start = edge.get(0);
                Integer end = edge.get(1);
                Integer weight = edge.get(2);

                if (distanceMap.get(start) != Integer.MAX_VALUE && distanceMap.get(start) + weight < distanceMap.get(end)) {
                    distanceMap.put(end, distanceMap.get(start) + weight);
                }
            }
        }
        Map<Integer, Integer> negativeCycleDetectionMap = Map.copyOf(distanceMap);

        // run above edge relax steps one more time. If map changes, then we know there is a negative cycle.
        for (List<Integer> edge : mapDef) {
            Integer start = edge.get(0);
            Integer end = edge.get(1);
            Integer weight = edge.get(2);

            if (distanceMap.get(start) != Integer.MAX_VALUE && distanceMap.get(start) + weight < distanceMap.get(end)) {
                distanceMap.put(end, distanceMap.get(start) + weight);
            }
        }

        // if maps not same, throw negative cycle exception
        if (!distanceMap.equals(negativeCycleDetectionMap)) {
            throw new RuntimeException("negative feedback cycle detected");
        }

        return distanceMap;
    }

}
