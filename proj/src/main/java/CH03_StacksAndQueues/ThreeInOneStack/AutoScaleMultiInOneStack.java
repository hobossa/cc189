package CH03_StacksAndQueues.ThreeInOneStack;

import java.util.EmptyStackException;

// similar to MultiInOnStack, but it would automatically scale out when there is no available space.
public class AutoScaleMultiInOneStack<T> {
    private final int numberOfStacks;
    private Object[] data;
    private int sizeAll;                   // size of items in all stacks
    private int capacityAll;

    private static class StackInfo {
        int startIndex;
        int size;
        int capacity;
    }

    private final AutoScaleMultiInOneStack.StackInfo[] stackInfos;

    public AutoScaleMultiInOneStack(int numberOfStacks, int defaultCapacity) {
        this.numberOfStacks = numberOfStacks;
        // capacity of each stack
        this.capacityAll = this.numberOfStacks * defaultCapacity;
        this.data = new Object[capacityAll];
        this.stackInfos = new AutoScaleMultiInOneStack.StackInfo[this.numberOfStacks];
        for (int i = 0; i < this.numberOfStacks; i++) {
            this.stackInfos[i] = new AutoScaleMultiInOneStack.StackInfo();
            this.stackInfos[i].startIndex = i * defaultCapacity;
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
            scaleUp();
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

    private void scaleUp() {
        Object[] temp = new Object[capacityAll*2];
        // move stacks
        int start = 0;
        for (int i = 0; i < numberOfStacks; i++) {
            StackInfo info = stackInfos[i];
            for (int j = 0; j < info.size; j++) {
                int index = info.startIndex + j;
                index %= capacityAll;
                temp[start + j] = data[index];
                data[index] = null;
            }
            // update stackInfo
            info.capacity *= 2;
            info.startIndex = start;
            start += info.capacity;
        }
        // update
        data = temp;
        capacityAll *= 2;
    }
}
