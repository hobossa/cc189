package CH08_RecursionAndDynamicProgramming.Coins;


// Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents), and
// pennies (1 cent), write code to calculate the number of ways of representing n cents.
// Hints: #300, #324, #343, #380, #394

public class CoinsTest {

    public static void main(String[] args) {
        int[] coinDenominations = {5, 1, 10, 25};

        for (int i = 1; i < 100; i++) {
            System.out.println("" + i + " cents: "
                    + Coins_v1.makeChange(i) + "  "
                    + Coins_v2.makeChange(i) + "  "
                    + Coins_v3.makeChange(i, coinDenominations) + " "
                    + Coins_v4.makeChange(i, coinDenominations));
        }
    }
}
