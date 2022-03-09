package CH08_RecursionAndDynamicProgramming.Coins;

// similar to Coins_v1, but it is recursion approach
public class Coins_v2 {
    public static int ways(int nCents) {
        return waysHelper(nCents, 3);
    }

    // magic = 0, only has 1 cent coins
    // magic = 1, has 1 cent and 5 cents coins
    // magic = 2, has 1 cent, 5 cents, and 10 cents coins
    // magic = 3, has 1 cent, 5 cents, 10 cents, and 25 cents coins.
    private static int waysHelper(int nCents, int magic) {
        if (0 == magic) {
            return 1;
        } else if (1 == magic) {
            return waysHelper(nCents, 0) + (nCents < 5 ? 0 : waysHelper(nCents - 5, 1));
        } else if (2 == magic) {
            return waysHelper(nCents, 1) + (nCents < 10 ? 0 : waysHelper(nCents - 10, 2));
        } else if (3 == magic) {
            return waysHelper(nCents, 2) + (nCents < 25 ? 0 : waysHelper(nCents - 25, 3));
        }
        return 0;
    }
}
