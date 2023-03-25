/**
 * 88. Merge Sorted Array
 * @see <a href="https://leetcode.com/problems/merge-sorted-array/"></a>
 */
package leetcode.twopointers;

import java.util.Arrays;

public class T88Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        // copy nums1[0:m]
        int[] tmp = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0;
        while (i<m && j<n){
            nums1[i+j] = tmp[i]<nums2[j] ? tmp[i++] : nums2[j++];
        }
        // if there are remains in tmp or nums2, attach them to the end of nums1 (i+j)
        if (i<m) System.arraycopy(tmp, i, nums1, i+j, m-i);
        if (j<n) System.arraycopy(nums2, j, nums1, i+j, n-j);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3,  n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
