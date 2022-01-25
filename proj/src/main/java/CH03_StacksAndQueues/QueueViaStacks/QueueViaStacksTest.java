package CH03_StacksAndQueues.QueueViaStacks;

// Implement a MyQueue class which implements a queue using two stacks.
// Hints: #98, #114

import java.util.concurrent.ThreadLocalRandom;

public class QueueViaStacksTest {

    public static void main(String[] args) {
        int v = 0;
        MyQueue_v1<Integer> myQueue1 = new MyQueue_v1<>();
        while (v < 50) {
            if (0 == ThreadLocalRandom.current().nextInt() % 2) {
                myQueue1.add(v);
                System.out.println(v);
                v++;
            } else {
                if (!myQueue1.empty()) {
                    System.out.println("        " + myQueue1.remove());
                }
            }
        }

        while (!myQueue1.empty()) {
            System.out.println("        " + myQueue1.remove());
        }
    }
}
