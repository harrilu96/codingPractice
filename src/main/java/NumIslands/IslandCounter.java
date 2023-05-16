package NumIslands;


public class IslandCounter {

    public static int CountIslands(int[][] map) {
        int numIslands = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.println("AT INDEX: " + i + "," + j);
                if (map[i][j] == 1) {
                    numIslands++;
                    removeIsland(map, i, j);
                }
            }
        }

        return numIslands;
    }

    public static void removeIsland(int[][] map, int i, int j) {
        if (i >= 0 && i < map.length && j >= 0 && j < map[i].length) {
            if (map[i][j] == 1) {
                map[i][j] = 0;
                removeIsland(map, i + 1, j);
                removeIsland(map, i - 1, j);
                removeIsland(map, i, j + 1);
                removeIsland(map, i, j - 1);
            }
        }
    }
}
