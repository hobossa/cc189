package CH03_StacksAndQueues.ThreeInOneStack;

// Describe how you could use a single array to implement three stacks.
// Hints: #2, #12, #38, #58

// version 1, Inherit from FixedMultiInOnStack
// ps: aggregate a FixedMultiInOnStack object is ok too.

public class ThreeInOneStackV1<T> extends  FixedMultiInOneStack<T> {
    public ThreeInOneStackV1(int capacity) {
        super(3, capacity);
    }

    public T pop1st() {
        return pop(0);
    }

    public T peek1st() {
        return peek(0);
    }

    public void push1st(T item) {
        push(item, 0);
    }

    public boolean isEmpty1st() {
        return isEmpty(0);
    }

    public T pop2nd() {
        return pop(1);
    }

    public T peek2nd() {
        return peek(1);
    }

    public void push2nd(T item) {
        push(item, 1);
    }

    public boolean isEmpty2nd() {
        return isEmpty(1);
    }

    public T pop3rd() {
        return pop(2);
    }

    public T peek3rd() {
        return peek(2);
    }

    public void push3rd(T item) {
        push(item, 2);
    }

    public boolean isEmpty3rd() {
        return isEmpty(2);
    }
}
