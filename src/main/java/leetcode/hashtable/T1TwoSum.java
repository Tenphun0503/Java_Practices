/**
 * 1. Two Sum
 * @see <a href="https://leetcode.com/problems/two-sum/description/"></a>
 */
package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class T1TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target-nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])&&map.get(nums[i])!=i){
                return new int[] {i, map.get(nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
