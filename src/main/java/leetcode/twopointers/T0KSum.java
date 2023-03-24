/**
 * This file shows the general solution for k-sum problem
 * @see <a href="https://leetcode.com/problems/4sum/editorial/"></a>
 */
package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T0KSum {
    /**
     * Basic problem of 2Sum
     * @param nums: the input nums
     * @param target: the target
     * @param start: 2Sum is searched from nums[start:]
     * @return res: the output
     */
    public static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;

        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
                ++lo;
            } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
            }
        }

        return res;
    }

    /**
     * K Sum
     * @param nums: the input nums
     * @param target: the target
     * @param start: k results are searched from nums[start:]
     * @param k: input k
     * @return res: the output
     */
    public static List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return res;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        long average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(List.of(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    /**
     * Example of a 4sum problem
     * @param nums: input
     * @param target: target
     * @return res: the possible results
     */
    public static List<List<Integer>> kSum(int[] nums, int target){
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        System.out.println(kSum(nums,target));
    }
}
