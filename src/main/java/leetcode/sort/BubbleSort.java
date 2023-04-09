/**
 * @see <a href=""></a>
 */
package leetcode.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]){
                    int tmp = nums[j];
                    nums[j]= nums[j-1];
                    nums[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {22,55,44,11,33};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
