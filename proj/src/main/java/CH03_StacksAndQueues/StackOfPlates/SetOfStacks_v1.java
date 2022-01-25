package CH03_StacksAndQueues.StackOfPlates;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks_v1<E> {
    private final int singleCapacity;
    private int size;
    //Vector<Stack<E>> stacks;    // vector is a legacy class.
    ArrayList<Stack<E>> stacks;

    public SetOfStacks_v1(int singleCapacity) {
        this.singleCapacity = singleCapacity;
        this.stacks = new ArrayList<>();
        this.size = 0;
    }

    public E pop() {
        if (0 == size) {
            throw new EmptyStackException();
        }
        size--;
        Stack<E> lastStack = stacks.get(stacks.size()-1);
        E e = lastStack.pop();
        if (0 == lastStack.size()) {
            stacks.remove(stacks.size()-1);
        }
        return e;
    }

    public E peek() {
        if (0 == size) {
            throw new EmptyStackException();
        }
        return stacks.get(stacks.size()-1).peek();
    }

    public E push(E e) {
        // this approach cannot handle popAt(int index), because this operation will cause the size of some stacks
        // less than singleCapacity.
        // if (size % singleCapacity == 0) {
        //     stacks.add(new Stack<E>());
        // }

        if (stacks.isEmpty() || singleCapacity == stacks.get(stacks.size()-1).size()) {
            stacks.add(new Stack<E>());
        }
        stacks.get(stacks.size()-1).push(e);
        size++;
        return e;
    }

    public E popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        E  e = stacks.get(index).pop();
        if (0 == stacks.get(index).size()) {
            stacks.remove(index);
        }
        return e;
    }

    public boolean empty() {
        return 0 == size;
    }
}
