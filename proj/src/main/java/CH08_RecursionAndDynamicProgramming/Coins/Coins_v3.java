package CH08_RecursionAndDynamicProgramming.Coins;


import java.util.Arrays;

// similar to Coins_v2, but use a parameter 'coinValues' to represent denominations of coins
// this is more flexible.
public class Coins_v3 {
    public static int ways(int nCents, int[] coinDenominations) {
        // make a copy of argument to avoid modifying it.
        int[] values = Arrays.copyOf(coinDenominations, coinDenominations.length);
        Arrays.sort(values);
        assert (values.length > 0 && values[0] == 1);
        return waysHelper(nCents, values, values.length - 1);
    }

    private static int waysHelper(int nCents, int[] coinDenominations, int magic) {
        if (0 == magic) {
            return 1;
        }
        return waysHelper(nCents, coinDenominations, magic - 1)
                + (nCents < coinDenominations[magic] ? 0 :
                waysHelper(nCents - coinDenominations[magic], coinDenominations, magic));
    }
}
