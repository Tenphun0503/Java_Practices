/**
 * 209. Minimum Size Subarray Sum
 *
 * @see <a href="https://leetcode.com/problems/minimum-size-subarray-sum/"></a>
 */
package leetcode.twopointers;
public class T209MinSubArrayLen {
    /**
     * Using two pointers
     */
    public static int solution1(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sumOfArray = 0;

        while (right < nums.length){
            sumOfArray += nums[right];
            while (sumOfArray >= target) {
                count = Math.min(count, right-left+1);
                sumOfArray -= nums[left++];
            }
            right ++;
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(solution1(target, nums));
    }
}
