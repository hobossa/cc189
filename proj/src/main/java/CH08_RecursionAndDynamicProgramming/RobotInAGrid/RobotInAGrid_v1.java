package CH08_RecursionAndDynamicProgramming.RobotInAGrid;

import java.util.ArrayList;

public class RobotInAGrid_v1 {
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
        path.add(cur);

        boolean ret = false;
        do {
            if (cur.row == grid.length - 1 && cur.column == grid[0].length - 1) {
                ret = true;
                break;
            }

            if (cur.row >= grid.length
                    || cur.column >= grid[0].length
                    || !grid[cur.row][cur.column]) {
                break;
            }

            // go right first;
            ret = getPath(path, new Point(cur.row, cur.column + 1), grid)
                    || getPath(path, new Point(cur.row + 1, cur.column), grid);
        } while (false);

        if (!ret) {
            path.remove(path.size() - 1);
        }

        return ret;
    }
}
