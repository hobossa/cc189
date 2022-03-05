package CH08_RecursionAndDynamicProgramming.TripleStep;

public class TripleStep_v2 {
    // Top-Down Dynamic Programming (or Memoization)
    public static int numberOfWays(int nSteps){
        if (nSteps == 0) {
            return 0;
        }
        int[] memo = new int[nSteps];
        return numberOfWays(nSteps, memo);
    }

    public static int numberOfWays(int nSteps, int[] memo) {
        if (nSteps == 1) {
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
            if (memo[nSteps-1] == 0) {
                memo[nSteps-1] = numberOfWays(nSteps - 3) + numberOfWays(nSteps - 2) + numberOfWays(nSteps - 1);
            }
            return memo[nSteps-1];
        }
    }
}
