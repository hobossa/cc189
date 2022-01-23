package CH03_StacksAndQueues.ThreeInOneStack;

import java.util.EmptyStackException;

public class FixedMultiInOneStack<T> {
    private final int numberOfStacks;
    private final int capacity;   // capacity of each stack
    int[] sizes;
    Object[] data;

    public FixedMultiInOneStack(int numberOfStacks, int capacity) {
        this.numberOfStacks = numberOfStacks;
        this.capacity = capacity;
        this.data = new Object[this.numberOfStacks * this.capacity];
        this.sizes = new int[this.numberOfStacks];
    }

    @SuppressWarnings("unchecked")
    public T pop(int kth) {
        if (isEmpty(kth)) {
            throw new EmptyStackException();
        }
        sizes[kth]--;
        int index = kth * capacity + sizes[kth];
        T item = (T) data[index];
        data[index] = null;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek(int kth) {
        if (isEmpty(kth)) {
            throw new EmptyStackException();
        }
        int index = kth * capacity + sizes[kth] - 1;
        return (T) data[index];
    }

    public void push(T item, int kth) {
        if (isFull(kth)) {
            throw new FullStackException();
        }
        int index = kth * capacity + sizes[kth]++;
        data[index] = item;
    }

    public boolean isEmpty(int kth) {
        if (kth < 0 || kth >= numberOfStacks) {
            throw new IndexOutOfBoundsException();
        }
        return sizes[kth] == 0;
    }

    private boolean isFull(int kth) {
        if (kth < 0 || kth >= numberOfStacks) {
            throw new IndexOutOfBoundsException();
        }
        return sizes[kth] == capacity;
    }
}