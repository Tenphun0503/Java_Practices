/**
 * @see <a href=""></a>
 */
package leetcode.sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {33, 22, 11, 44, 55};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
