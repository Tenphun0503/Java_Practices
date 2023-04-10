/**
 * 454. 4Sum II
 *
 * @see <a href="https://leetcode.com/problems/4sum-ii/"></a>
 */
package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class T454FourSumCount {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(-(i + j), map.getOrDefault(-(i + j), 0) + 1);
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                count += map.getOrDefault(i+j, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,-1};
        int[] nums2 = {-1,1};
        int[] nums3 = {-1,1};
        int[] nums4 = {1,-1};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
