/**
 * 209. Minimum Size Subarray Sum
 * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/"></a>
 */
package leetcode.others;

import java.util.Arrays;

public class T209MinSubArrayLen {
    private static int sumOfArray(int[] nums){
        int res = 0;
        for (int num: nums){
            res += num;
        }
        return res;
    }

    private static int[] concatenate(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, res, 0, nums1.length);
        System.arraycopy(nums2, 0, res, nums1.length, nums2.length);
        return res;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = nums.length-1, count = 0;
        minSubArrayLen(target, nums, left, right, count);
        return count;
    }

    private static int[] minSubArrayLen(int target, int[] nums, int left, int right, int count) {
        if (count>0) return Arrays.copyOfRange(nums, left, right);
        if (left == right) return new int[]{nums[left]};

        int mid = (left + right) / 2;
        int[] leftPart = minSubArrayLen(target, nums, left, mid, count);
        int[] rightPart = minSubArrayLen(target, nums, mid+1, right, count);

        int[] newNums = concatenate(leftPart, rightPart);
        if (sumOfArray(newNums) >= target) count = newNums.length;
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};


        int target = 213;
        System.out.println(minSubArrayLen(target, nums));
    }
}
