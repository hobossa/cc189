package CH03_StacksAndQueues.StackOfPlates;

// Image a (literal) stack of plates. If the stack gets too high. it might topple. Therefore, in real life,
// we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
// SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack
// once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to
// a single stack (that is, pop() should return the same values as it would if there were just a single stack).
// FOLLOW-UP
// Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
// Hints: #64, #81

// todo: shift elements to make sure every sub stacks (except the last one) are full when popAt() is called.
// to achieve this. we may need to use other structure instead of java.util.Stack as the inner stack.

public class StackOfPlatesTest {

    public static void main(String[] args) {
        int singleCapacity = 5;
        SetOfStacks_v1<Integer> set = new SetOfStacks_v1<>(singleCapacity);
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        while (!set.empty()) {
            System.out.println("Popped " + set.pop());
        }
        // System.out.println("Popped " + set.pop());
    }
}
