package CH08_RecursionAndDynamicProgramming.StackOfBoxes;

public class Box {
    private int w;
    private int h;
    private int d;

    public Box(int w, int h, int d) {
        this.w = w;
        this.h = h;
        this.d = d;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getD() {
        return d;
    }

    // Box-this can be above Box-o.
    public boolean canBeAbove(Box o) {
        return this.w < o.w && this.h < o.h && this.d < o.d;
    }

    @Override
    public String toString() {
        return "Box - w:" + this.w + " h:" + this.h + " d:" + this.d;
    }
}
