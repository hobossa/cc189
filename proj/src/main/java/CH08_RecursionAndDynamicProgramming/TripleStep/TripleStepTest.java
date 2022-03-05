package CH08_RecursionAndDynamicProgramming.TripleStep;

// A child is running up a staircase with n Steps and can hop either 1 step, 2 steps, or 3 steps at a time.
// Implement a method to count how many possible ways the child can run up the stairs.

// Hints: #152, #178, #217, #237, #262, #359

public class TripleStepTest {
    public static void main(String[] args) {
        for (int i = 10; i < 20; i++) {
            System.out.print(" " +TripleStep_v1.numberOfWays(i));
            System.out.print(" " +TripleStep_v2.numberOfWays(i));
            System.out.println(" " +TripleStep_v3.numberOfWays(i));
        }
    }

}
