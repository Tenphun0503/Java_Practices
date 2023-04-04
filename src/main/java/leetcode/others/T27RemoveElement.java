/**
 * 27. Remove Element
 * @see <a href="https://leetcode.com/problems/remove-element/"></a>
 */
package leetcode.others;

import java.util.Arrays;

public class T27RemoveElement {
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        int k = 0;
        while (i<=j){
            while (i<=j && nums[i] == val) {
                k++;
                swap(nums, i, j--);
            }
            i++;
        }
        return nums.length - k;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int val = 1;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
