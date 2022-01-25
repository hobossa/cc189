package CH03_StacksAndQueues.QueueViaStacks;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyQueue_v1<E> {
    private final Stack<E> stackIn;
    private final Stack<E> stackOut;

    public MyQueue_v1() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void add(E e) {
        stackIn.add(e);
    }

    public E remove() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        if (stackOut.empty()) {
            shift();
        }
        return stackOut.pop();
    }

    public E peek() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        if (stackOut.empty()) {
            shift();
        }
        return stackOut.pop();
    }

    public boolean empty() {
        return stackOut.empty() && stackIn.empty();
    }

    private void shift() {
        assert (stackOut.empty());
        while (!stackIn.empty()) {
            stackOut.add(stackIn.pop());
        }
    }
}
