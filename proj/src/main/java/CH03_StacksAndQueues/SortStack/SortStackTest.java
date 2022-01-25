package CH03_StacksAndQueues.SortStack;

// Write a program to sort a stack such that the smallest items are on the top. You can use an additional
// temporary stack, but you may not copy the elements into any other data structure (such as an array).
// The stack supports the following operations: push, pop, peek, and isEmpty.
// Hints: #15, #32, #43

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class SortStackTest {

    public static void main(String[] args) {
        Stack<Integer>  testStack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            int v = ThreadLocalRandom.current().nextInt(0, 100);
            testStack.add(v);
            System.out.println(v);
        }
        System.out.println();
        // SortStack_v1<Integer> sort1 = new SortStack_v1<>();
        // sort1.sort(testStack);
        SortStack_v2.sort(testStack);
        while (!testStack.empty()) {
            System.out.println(testStack.pop());
        }
    }
}
