package CH08_RecursionAndDynamicProgramming.TripleStep;

public class TripleStep_v1 {
    // In fact this is very similar to Fibonacci.
    // Normal Recursion
    public static int numberOfWays(int nSteps) {
        if (nSteps == 0) {
            return 0;
        } else if (nSteps == 1) {
            return 1;
        } else if (nSteps == 2) {
            // 1,1
            // 2
            return 2;
        } else if (nSteps == 3) {
            // hop 3 steps
            // 1 + numberOfWays (2)
            // 2 + numberOfWays (1)
            return 4;
        } else {
            // nSteps >=4
            // 1 + number of Ways hop n-3 steps
            // 2 + number of ways hop n-2 steps
            // 3 + number of ways hop n-1 steps
            return numberOfWays(nSteps - 3) + numberOfWays(nSteps - 2) + numberOfWays(nSteps - 1);
        }
    }

    // another approach, treat n <= 0 in a different way. then we can simplify the code as the following.
    public static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }
}
