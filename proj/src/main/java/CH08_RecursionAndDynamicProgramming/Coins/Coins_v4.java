package CH08_RecursionAndDynamicProgramming.Coins;

// method from book

import java.util.Arrays;
import java.util.Collections;

public class Coins_v4 {
    public static int makeChange(int n, int[] coinDenominations) {
        Integer[] denoms = Arrays.stream(coinDenominations).boxed().toArray(Integer[]::new);
        Arrays.sort(denoms, Collections.reverseOrder());
        int[][] memo = new int[n+1][coinDenominations.length];
        return makeChangeHelper(n, denoms, 0, memo);
    }

    private static int makeChangeHelper(int n, Integer[] coinDenominations, int index, int[][] memo) {
        if (n == 0 || index == coinDenominations.length-1) {
            return 1;
        }
        if (memo[n][index] != 0){
            return memo[n][index];
        }
        int denom = coinDenominations[index];
        int m = n / denom;
        int ways = 0;
        for (int i = 0; i <= m; i++) {
            ways += makeChangeHelper(n - i * denom, coinDenominations, index + 1, memo);
        }
        memo[n][index] = ways;
        return ways;
    }
}
