package MY.KSum;

import java.util.List;

// leetcode #.18

public class KSumTest {

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        // KSumHash kSumHash = new KSumHash();
        // List<List<Integer>> res = kSumHash.kSum(nums, target, 4);

        KSumTwoPoint kSum2Point = new KSumTwoPoint();
        List<List<Integer>> res = kSum2Point.kSum(nums, target, 4);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
