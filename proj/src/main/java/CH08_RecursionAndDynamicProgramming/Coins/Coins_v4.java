package CH08_RecursionAndDynamicProgramming.Coins;

// method from book

import java.util.Arrays;
import java.util.Collections;

public class Coins_v4 {
    public static int makeChange(int n, int[] coinDenominations) {
        Integer[] denoms = Arrays.stream(coinDenominations).boxed().toArray(Integer[]::new);
        Arrays.sort(denoms, Collections.reverseOrder());
        return makeChangeHelper(n, denoms, 0);
    }

    private static int makeChangeHelper(int n, Integer[] coinDenominations, int index) {
        if (n == 0 || index == coinDenominations.length-1) {
            return 1;
        }
        int denom = coinDenominations[index];
        int m = n / denom;
        int ways = 0;
        for (int i = 0; i <= m; i++) {
            ways += makeChangeHelper(n - i * denom, coinDenominations, index + 1);
        }
        return ways;
    }
}
