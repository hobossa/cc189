package CH03_StacksAndQueues.StackMin;

import java.util.Stack;

public class StackMin_v3<E extends Comparable<? super E>> implements IStackMin<E> {

    private final Stack<E> innerStack;
    // use a dedicated stack to save current min element;
    private final Stack<E> minStack;

    public StackMin_v3() {
        innerStack = new Stack<>();
        minStack = new Stack<>();
    }

    public E min() {
        return minStack.peek();
    }

    public E push(E item) {
        if (isEmpty()) {
            minStack.push(item);
        } else {
            E min = min();
            if (item.compareTo(min) < 0) {
                minStack.push(item);
            } else {
                minStack.push(min);
            }
        }

        innerStack.push(item);
        return item;
    }

    public E peek() {
        return innerStack.peek();
    }

    public E pop() {
        minStack.pop();
        return innerStack.pop();
    }

    public boolean isEmpty() {
        return innerStack.empty();
    }
}
