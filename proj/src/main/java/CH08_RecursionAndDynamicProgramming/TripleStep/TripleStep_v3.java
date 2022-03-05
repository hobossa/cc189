package CH08_RecursionAndDynamicProgramming.TripleStep;

public class TripleStep_v3 {
    // Bottom-Up Dynamic Programming
    public static int numberOfWays(int nSteps){
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
        }

        int[] memo = new int[nSteps];
        memo[0] = 1;    // number of ways hope 1 steps.
        memo[1] = 2;    // number of ways hope 2 steps.
        memo[2] = 4;    // number of ways hope 3 steps.
        for (int i = 3; i < nSteps; i++) {
            memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
        }
        return memo[nSteps-1];
    }
}
