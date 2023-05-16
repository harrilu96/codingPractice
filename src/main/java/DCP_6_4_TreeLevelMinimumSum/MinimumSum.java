package DCP_6_4_TreeLevelMinimumSum;

import java.util.ArrayList;
import java.util.List;

public class MinimumSum {

    // return the level with the minimum sum
    public static int MinimumSum(Node root) {
        List<Node> currentLevel = List.of(root);
        List<Node> nextLevel = new ArrayList<>();
        int minimumSum = Integer.MAX_VALUE;
        int currentLevelIndex = 0;
        int minSumLevelIndex = 0;

        while(!currentLevel.isEmpty()) {
            int levelRunningTotal = 0;
            for(Node node : currentLevel) {
                levelRunningTotal += node.getValue();
                if (node.getLeft() != null) {
                    nextLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextLevel.add(node.getRight());
                }
            }
            if (levelRunningTotal < minimumSum) {
                minimumSum = levelRunningTotal;
                minSumLevelIndex = currentLevelIndex;
            }
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
            currentLevelIndex++;
        }

        return minSumLevelIndex;
    }

}
