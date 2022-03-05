package CH08_RecursionAndDynamicProgramming.RobotInAGrid;

import java.util.ArrayList;

public class RobotInAGrid_v2 {
    // this solution get the reverse path, that is from bottom right corner to up left corner.
    public static ArrayList<Point> getPath(boolean[][] grid) {
        ArrayList<Point> path = new ArrayList<>();
        if (null == grid || 0 == grid.length || 0 == grid[0].length) {
            return path;
        }
        getPath(path, new Point(0, 0), grid);
        return path;
    }

    // DFS (depth first search)  PS: BFS: breadth first search
    private static boolean getPath(ArrayList<Point> path, Point cur, boolean[][] grid) {
        if (cur.row >= grid.length
                || cur.column >= grid[0].length
                || !grid[cur.row][cur.column]) {
            return false;
        }
        boolean ret = false;

        if (cur.row == grid.length - 1 && cur.column == grid[0].length - 1) {
            ret = true;
        } else {
            // go right first;
            ret = getPath(path, new Point(cur.row, cur.column + 1), grid)
                    || getPath(path, new Point(cur.row + 1, cur.column), grid);
        }

        if (ret) {
            path.add(cur);
        }

        return ret;
    }
}
