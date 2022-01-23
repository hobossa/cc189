package CH03_StacksAndQueues.ThreeInOneStack;


import java.util.EmptyStackException;

// similar to FixedMultiInOneStack, but allow flexible divisions (shift divisions when needed).
public class MultiInOneStack<T> {
    private final int numberOfStacks;
    private final int defaultCapacity;   // capacity of each stack
    private Object[] data;
    private int sizeAll;                   // size of items in all stacks
    private final int capacityAll;

    private static class StackInfo {
        int startIndex;
        int size;
        int capacity;
    }

    private StackInfo[] stackInfos;

    public MultiInOneStack(int numberOfStacks, int defaultCapacity) {
        this.numberOfStacks = numberOfStacks;
        this.defaultCapacity = defaultCapacity;
        this.capacityAll = this.numberOfStacks * this.defaultCapacity;
        this.data = new Object[capacityAll];
        this.stackInfos = new StackInfo[this.numberOfStacks];
        for (int i = 0; i < this.numberOfStacks; i++) {
            this.stackInfos[i] = new StackInfo();
            this.stackInfos[i].startIndex = i * this.defaultCapacity;
            this.stackInfos[i].capacity = defaultCapacity;
            this.stackInfos[i].size = 0;
        }
    }


    public boolean isEmpty(int kth) {
        if (kth < 0 || kth >= numberOfStacks) {
            throw new IndexOutOfBoundsException();
        }
        return 0 == stackInfos[kth].size;
    }

    private boolean isFull(int kth) {
        if (kth < 0 || kth >= numberOfStacks) {
            throw new IndexOutOfBoundsException();
        }
        return stackInfos[kth].capacity == stackInfos[kth].size;
    }

    private boolean isAllStacksFull() {
        return sizeAll == capacityAll;
    }

    @SuppressWarnings("unchecked")
    public T pop(int kth) {
        if (isEmpty(kth)) {
            throw new EmptyStackException();
        }
        stackInfos[kth].size--;
        int index = stackInfos[kth].startIndex + stackInfos[kth].size;
        index %= capacityAll;
        T item = (T) data[index];
        data[index] = null;
        sizeAll--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek(int kth) {
        if (isEmpty(kth)) {
            throw new EmptyStackException();
        }
        int index = stackInfos[kth].startIndex + stackInfos[kth].size - 1;
        index %= capacityAll;
        return (T) data[index];
    }

    public void push(T item, int kth) {
        if (isAllStacksFull()) {
            throw new FullStackException();
        }
        if (isFull(kth)) {
            // need to do shift;
            shift((kth + 1) % numberOfStacks);
        }
        int index = stackInfos[kth].startIndex + stackInfos[kth].size++;
        index %= capacityAll;
        data[index] = item;
        sizeAll++;
    }

    private void shift(int kth) {
        if (isFull(kth)) {
            // need to shift the next division first.
            shift((kth + 1) % numberOfStacks);
        }
        // give at least half of available space to previous division.
        int available = stackInfos[kth].capacity - stackInfos[kth].size;
        int off = available - (available) / 2;
        // move the data
        for (int i = stackInfos[kth].size - 1; i >= 0; i--) {
            int index = stackInfos[kth].startIndex + i;
            data[(index + off) % capacityAll] = data[index % capacityAll];
        }
        for (int i = 0; i < off; i++) {
            int index = stackInfos[kth].startIndex + i;
            index %= capacityAll;
            data[index] = null;
        }
        // update stackInfo
        stackInfos[kth].startIndex += off;
        stackInfos[kth].startIndex %= capacityAll;
        stackInfos[kth].capacity -= off;
        // update previous division's stackInfo
        stackInfos[(kth - 1 + numberOfStacks) % numberOfStacks].capacity += off;
    }
}
