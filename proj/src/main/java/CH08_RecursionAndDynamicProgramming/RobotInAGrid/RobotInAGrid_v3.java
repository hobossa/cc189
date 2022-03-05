package CH08_RecursionAndDynamicProgramming.RobotInAGrid;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid_v3 {

    // this solution get the reverse path, that is from bottom right corner to up left corner.
    // similar to version 2, but cache the points that cannot reach the destination.
    public static ArrayList<Point> getPath(boolean[][] grid) {
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (null == grid || 0 == grid.length || 0 == grid[0].length) {
            return path;
        }
        getPath(failedPoints, path, new Point(0, 0), grid);
        return path;
    }

    // DFS (depth first search)  PS: BFS: breadth first search
    private static boolean getPath(HashSet<Point> failedPoints, ArrayList<Point> path, Point cur, boolean[][] grid) {
        if (cur.row >= grid.length
                || cur.column >= grid[0].length
                || !grid[cur.row][cur.column]) {
            return false;
        }
        if (failedPoints.contains(cur)) {
            return false;
        }

        boolean ret = false;

        if (cur.row == grid.length - 1 && cur.column == grid[0].length - 1) {
            ret = true;
        } else {
            // go right first;
            ret = getPath(failedPoints, path, new Point(cur.row, cur.column + 1), grid)
                    || getPath(failedPoints, path, new Point(cur.row + 1, cur.column), grid);
        }

        if (ret) {
            path.add(cur);
        } else {
            failedPoints.add(cur);
        }

        return ret;
    }
}
