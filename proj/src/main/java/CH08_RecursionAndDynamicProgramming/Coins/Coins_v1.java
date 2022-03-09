package CH08_RecursionAndDynamicProgramming.Coins;

// Dynamic programming
// matrix  w[x][y]
//       values  |  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18.........
// ---------------------------------------------------------------------------------------------------
// 1 c coin    0 |  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1.........
// + 5 c coin  1 |  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3,  3,  3,  3,  3,  4,  4,  4,  4........
// +10 c coin  2 |  1,  1,  1, .... if (value - 10 >= 0) {w[x-1][y] + w[x][y-10]} else {w[x-1][y]}
// +25 c coin  3 |


// brute force, calculate all values int the matrix.
public class Coins_v1 {

    public static int ways(int nCents) {
        int[][] w = new int[4][nCents+1];

        // in fact, we don't need to save this all value 1 array.
        for (int i = 0; i <= nCents; i++) {
            w[0][i] = 1;    // only 1 way to represent n cents when we only have 1 cent coins.
        }
        // when we have 1 cent and 5 cents coins
        for (int i = 0; i <=nCents ; i++) {
                w[1][i] = w[0][i] + (i - 5 >=0 ? w[1][i-5] : 0);
        }
        // 1, 5, 10
        for (int i = 0; i <=nCents ; i++) {
            w[2][i] = w[1][i] + (i - 10 >=0 ? w[2][i-10] : 0);
        }
        // 1, 5, 10, 25
        for (int i = 0; i <=nCents ; i++) {
            w[3][i] = w[2][i] + (i - 25 >=0 ? w[3][i-25] : 0);
        }

        return w[3][nCents];
    }
}
