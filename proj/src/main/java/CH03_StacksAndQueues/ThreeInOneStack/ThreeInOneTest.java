package CH03_StacksAndQueues.ThreeInOneStack;


public class ThreeInOneTest {
    public static void testV1() {
        ThreeInOneStackV1<Integer> fixedStack = new ThreeInOneStackV1<>(5);

        // fixedStack.peek3rd();
        // fixedStack.pop3rd();
        for (int i = 0; i < 5; i++) {
            fixedStack.push3rd(i + 20);
            System.out.println(fixedStack.peek3rd());
        }
        // fixedStack.push3rd(16);

        // fixedStack.peek1st();
        // fixedStack.pop1st();
        for (int i = 0; i < 5; i++) {
            fixedStack.push1st(i);
            System.out.println(fixedStack.peek1st());
        }
        // fixedStack.push1st(6);

        // fixedStack.peek2nd();
        // fixedStack.pop2nd();
        for (int i = 0; i < 5; i++) {
            fixedStack.push2nd(i + 10);
            System.out.println(fixedStack.peek2nd());
        }
        // fixedStack.push2nd(16);

        for (int i = 0; i < 5; i++) {
            System.out.println(fixedStack.pop1st());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(fixedStack.pop3rd());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(fixedStack.pop2nd());
        }

        System.out.println();
    }


    public static void testV2() {
        ThreeInOneStackV2<Integer> flexStack = new ThreeInOneStackV2<>(5);
        // flexStack.peek1st();
        // flexStack.pop1st();
        for (int i = 0; i < 3; i++) {
            flexStack.push1st(i);
            flexStack.push2nd(10 + i);
            flexStack.push3rd(20 + i);
        }

        for (int i = 0; i < 6; i++) {
            flexStack.push1st(i);
            System.out.println(flexStack.peek1st());
        }
        System.out.println();

        // for (int i = 0; i < 5; i++) {
        //     flexStack.push2nd(i + 10);
        //     System.out.println(flexStack.peek2nd());
        // }
        // System.out.println();
        //
        // for (int i = 0; i < 2; i++) {
        //     flexStack.push3rd(i + 20);
        //     System.out.println(flexStack.peek3rd());
        // }
        // System.out.println();
        //
        // for (int i = 0; i < 3; i++) {
        //     System.out.println(flexStack.pop2nd());
        // }
        // System.out.println();
        //
        // for (int i = 0; i < 3; i++) {
        //     flexStack.push3rd(i + 20);
        //     System.out.println(flexStack.peek3rd());
        // }
        // System.out.println();
        //
        for (int i = 0; i < 3; i++) {
            System.out.println(flexStack.pop1st());
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            flexStack.push3rd(i + 20);
            System.out.println(flexStack.peek3rd());
        }
        System.out.println();

        while (!flexStack.isEmpty1st()) {
            System.out.println(flexStack.pop1st());
        }
        System.out.println();

        while (!flexStack.isEmpty2nd()) {
            System.out.println(flexStack.pop2nd());
        }
        System.out.println();

        while (!flexStack.isEmpty3rd()) {
            System.out.println(flexStack.pop3rd());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        testV2();
    }
}
