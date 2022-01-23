package CH03_StacksAndQueues.ThreeInOneStack;

public class ThreeInOneStackV2<T> {
    // aggregate
    private final MultiInOneStack<T> multiInOneStack;

    public ThreeInOneStackV2(int defaultCapacity) {
        this.multiInOneStack = new MultiInOneStack<>(3, defaultCapacity);
    }

    public T pop1st() {
        return multiInOneStack.pop(0);
    }

    public T peek1st() {
        return multiInOneStack.peek(0);
    }

    public void push1st(T item) {
        multiInOneStack.push(item, 0);
    }

    public boolean isEmpty1st() {
        return multiInOneStack.isEmpty(0);
    }

    public T pop2nd() {
        return multiInOneStack.pop(1);
    }

    public T peek2nd() {
        return multiInOneStack.peek(1);
    }

    public void push2nd(T item) {
        multiInOneStack.push(item, 1);
    }

    public boolean isEmpty2nd() {
        return multiInOneStack.isEmpty(1);
    }

    public T pop3rd() {
        return multiInOneStack.pop(2);
    }

    public T peek3rd() {
        return multiInOneStack.peek(2);
    }

    public void push3rd(T item) {
        multiInOneStack.push(item, 2);
    }

    public boolean isEmpty3rd() {
        return multiInOneStack.isEmpty(2);
    }
}
