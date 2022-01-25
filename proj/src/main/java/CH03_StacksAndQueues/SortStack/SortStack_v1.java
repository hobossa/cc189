package CH03_StacksAndQueues.SortStack;

import java.util.Stack;

// brute force:  time O(n*n), space O(n)
public class SortStack_v1<T extends Comparable<? super T>> {

    private final Stack<T> tempStack;

    public SortStack_v1() {
        this.tempStack = new Stack<>();
    }

    public void sort(Stack<T> stack) {
        if (stack.empty()) return;
        int size = size(stack);
        sortInner(stack, size);
    }

    public void sortInner(Stack<T> stack, int size) {
        if (1 == size) {
            return;
        }
        int tempSize = size;
        T max = stack.pop();
        tempSize--;

        while (tempSize > 0) {
            T temp = stack.pop();
            if (temp.compareTo(max) > 0) {
                tempStack.add(max);
                max = temp;
            } else {
                tempStack.add(temp);
            }
            tempSize--;
        }
        stack.add(max);
        while (!tempStack.empty()) {
            stack.add(tempStack.pop());
        }
        sortInner(stack, size-1);
    }

    private int size(Stack<T> stack) {
        int size = 0;
        while (!stack.empty()) {
            size++;
            tempStack.add(stack.pop());
        }
        while (!tempStack.empty()) {
            stack.add((tempStack.pop()));
        }
        return size;
    }
}
