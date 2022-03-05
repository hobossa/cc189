package CH08_RecursionAndDynamicProgramming.RobotInAGrid;

public class Point {
    public int row;
    public int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Point)
                && ((Point) obj).row == this.row
                && ((Point) obj).column == this.column;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
