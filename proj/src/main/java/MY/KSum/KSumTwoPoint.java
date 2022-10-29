package MY.KSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSumTwoPoint {
    public List<List<Integer>> kSum(int[] nums, int target, int k) {
        Arrays.sort(nums);
        return kSumTwoPoint(nums, target, k, 0);
    }

    private List<List<Integer>> kSumTwoPoint(int[] nums, int target, int k, int start) {
        if (k <= 1) {
            return null;
        }

        if (k == 2) {
            return twoSumTwoPoint(nums, target, start);
        }

        List<List<Integer>> res = new ArrayList<>();
        int average = target / k;

        for (int i = start; i < nums.length - k + 1 & nums[i] <= average; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                List<List<Integer>> subRes = kSumTwoPoint(nums, target - nums[i], k - 1, i + 1);
                for (List<Integer> sub : subRes) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(sub);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> twoSumTwoPoint(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int end = nums.length-1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target || sum < target) {
                if (sum == target) {
                    res.add(Arrays.asList(nums[start], nums[end]));
                }
                ++start;
                while (start < end && nums[start] == nums[start-1]) {
                    ++start;
                }
            } else {
                --end;
            }
        }

        return  res;
    }
}
