package CH08_RecursionAndDynamicProgramming.RobotInAGrid;

// Imagine a robot sitting on the upper left corner of a grid with r rows and c columns. The robot can only move
// in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them.
// Design an algorithm to find a path for the robot from the top left to the bottom right.

// Hints: #331, #360, #388

import java.util.ArrayList;

public class RobotInAGridTest {

    public static void main(String[] args) {
        boolean[][] grid = {
                {true, true, true, true},
                {true, true, false, true},
                {true, true, true, false},
                {false, false, true, true}
        };

        ArrayList<Point> path = RobotInAGrid_v1.getPath(grid);
        System.out.println(path);
    }
}
