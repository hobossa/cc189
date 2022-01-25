package CH03_StacksAndQueues.StackMin;

// How would you design a stack which, in addition to push and pop, has a function min
// which return the minimum element? push, pop and min should all operate in O(1) time.
// Hints: #27, #59, #78

//

import java.util.concurrent.ThreadLocalRandom;

public class StackMinTest {
    public static void test(IStackMin<Integer> stack) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 20; i++) {
            int r = ThreadLocalRandom.current().nextInt(0, 1000);
            if ( r < min ) min = r;
            stack.push(r);
            System.out.println(stack.min());
            System.out.println(min);
        }
        System.out.println(stack.min());

    }

    public static void main(String[] args) {
        StackMin_v1<Integer> stackMin1 = new StackMin_v1<>(100);
        // StackMin_v2<Integer> stackMin2 = new StackMin_v2<>();
        // StackMin_v3<Integer> stackMin3 = new StackMin_v3<>();
        test(stackMin1);
    }
}
