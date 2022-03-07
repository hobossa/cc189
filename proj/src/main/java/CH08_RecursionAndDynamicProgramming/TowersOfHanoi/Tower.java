package CH08_RecursionAndDynamicProgramming.TowersOfHanoi;

import java.util.Stack;

public class Tower {
    private final String name;
    private Stack<Integer> disks;

    public Tower(String name) {
        this.disks = new Stack<>();
        this.name = name;
    }

    public int size() {
        return disks.size();
    }

    public boolean moveTopTo(Tower dest) {
        if (isEmpty()) {
            return false;
        }
        return dest.addDisk(this.popTopDisk());
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }

    public boolean addDisk(int n) {
        if (!isEmpty() && n >= topDisk()) {
            return false;
        }
        disks.add(n);
        return true;
    }

    public int popTopDisk() {
        assert(!isEmpty());
        return disks.pop();
    }

    public int topDisk() {
        return disks.peek();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tower: "). append(name).append(": ").append(disks.toString());
        return stringBuilder.toString();
    }
}
