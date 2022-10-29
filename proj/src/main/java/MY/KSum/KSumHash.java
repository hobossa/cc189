package MY.KSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class KSumHash {
    public List<List<Integer>> kSum(int[] nums, int target, int k) {
        Arrays.sort(nums);
        return kSumHashSet(nums, target, k, 0);
    }

    private List<List<Integer>> kSumHashSet(int[] nums, int target, int k, int start) {
        if (k <= 1) return null;

        if (k == 2) {
            return twoSumHashSet(nums, target, start);
        }

        List<List<Integer>> res = new ArrayList<>();
        int average = target / k;

        for (int i = start; i < nums.length - k + 1 && nums[i] <= average; ++i) {
            if (i == start || nums[i] != nums[i - 1]) {
                List<List<Integer>> subRes = kSumHashSet(nums, target - nums[i], k - 1, i + 1);
                if (subRes == null) continue;
                for (List<Integer> sub : subRes) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.addAll(sub);
                    res.add(tempList);
                }
            }
        }


        return res;
    }

    // nums should be sorted by ascending
    private List<List<Integer>> twoSumHashSet(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int i = start; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(complement, nums[i]));
                // remove dup
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    ++i;
                }
            }
            seen.add(nums[i]);
        }
        return res;
    }
}
