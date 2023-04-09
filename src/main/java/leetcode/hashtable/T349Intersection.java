/**
 * @see <a href=""></a>
 */
package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class T349Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if(set1.contains(i))set2.add(i);
        }
        int[] res = new int[set2.size()];
        int idx = 0;
        for (int s:set2) {
            res[idx++] = s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
