package CH03_StacksAndQueues.StackMin;

import Common.FullStackException;

import java.util.EmptyStackException;

public class StackMin_v1<T extends Comparable<? super T>> implements IStackMin<T> {
    private final int capacity;
    private int size;
    private InnerItem[] data;

    public StackMin_v1(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        data = new InnerItem[this.capacity];
    }

    private static class InnerItem {
        Object item;
        int iMin;   // index to the minimal item;

        public InnerItem(Object item, int iMin) {
            this.item = item;
            this.iMin = iMin;
        }
    }

    private boolean isFull() {
        return capacity == size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T push(T t) {
        if (isFull()) {
            throw new FullStackException();
        }
        int curMin = 0;
        if (!isEmpty()) {
            curMin = data[size - 1].iMin;
            if (t.compareTo((T) data[curMin].item) < 0) {
                curMin = size;
            }
        }
        data[size++] = new InnerItem(t, curMin);
        return t;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        InnerItem temp = data[--size];
        data[size] = null;
        return (T) temp.item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) data[size - 1].item;
    }

    @SuppressWarnings("unchecked")
    public T min() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int curMin = data[size - 1].iMin;
        return (T) data[curMin].item;
    }
}
