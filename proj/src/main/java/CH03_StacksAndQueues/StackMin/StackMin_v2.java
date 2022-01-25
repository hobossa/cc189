package CH03_StacksAndQueues.StackMin;

import java.util.Stack;


public class StackMin_v2<E extends Comparable<? super E>> implements IStackMin<E>{

    private static class InnerNode<E> {
        E item;
        E min;

        public InnerNode(E e, E min) {
            this.item = e;
            this.min = min;
        }
    }
    private final Stack<InnerNode<E>> innerStack;

    public StackMin_v2() {
        innerStack = new Stack<>();
    }

    public E min() {
        return innerStack.peek().min;
    }

    public E push(E item) {
        InnerNode<E> node = new InnerNode<>(item, null);
        if (isEmpty()) {
            node.min = node.item;
        } else {
            node.min = min();
            if (item.compareTo(node.min) < 0) {
                node.min = node.item;
            }
        }
        innerStack.push(node);
        return item;
    }

    public E peek() {
        return innerStack.peek().item;
    }

    public E pop() {
        return innerStack.pop().item;
    }

    public boolean isEmpty() {
        return innerStack.isEmpty();
    }
}
