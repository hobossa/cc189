package CH10_SortingAndSearching.RankFromStream;

// Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish to be able
// to look up the rank of a number x (the number of values less than or equal to x). Implement the data
// structures and algorithms to support these operations. That is, implement the method track (int x),
// which is called when each number is generated, and the method getRankOfNumber(int x), which returns
// the number of values less than or equal to x (not including x itself).
// EXAMPLE
// Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
// getRankOfNumber(l) = 0
// getRankOfNumber(3) = 1
// getRankOfNumber(4) = 3
// Hints: #301, #376, #392

import java.util.concurrent.ThreadLocalRandom;

public class RankFromStreamTest {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 4, 5, 9, 7, 13, 3};
        RankFromStream_v1 r1 = new RankFromStream_v1();
        for (int i = 0; i < arr.length; i++) {
            //int n = ThreadLocalRandom.current().nextInt(100,999);
            r1.track(arr[i]);
        }
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(r1.getRankOfNumber(arr[i]));
        // }
        for (int i = 0; i < 15; i++) {
            System.out.println("" + i + " : " + r1.getRankOfNumber(i));
        }
    }
}
