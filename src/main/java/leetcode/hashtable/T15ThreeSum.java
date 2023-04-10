/**
 * 15. 3Sum
 * @see <a href="https://leetcode.com/problems/3sum/"></a>
 */
package leetcode.hashtable;

import leetcode.twopointers.T0KSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T15ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res;
        Arrays.sort(nums);
        res = T0KSum.kSum(nums, 0, 0, 3);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

}
