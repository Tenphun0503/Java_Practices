/**
 * 977. Squares of a Sorted Array
 * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/description/"></a>
 */
package leetcode.others;

import java.util.Arrays;

public class T977SortedSquares {
    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int index = 0;
        while(left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                res[index] = nums[left] * nums[left];
                left++;
            }else{
                res[index] = nums[right] * nums[right];
                right--;
            }
            index ++;
        }
        reverse(res);
        return res;
    }

    private static void reverse(int[] res) {
        int left = 0;
        int right = res.length-1;
        while(left<right){
            res[left] = res[left] ^ res[right];
            res[right] = res[left] ^ res[right];
            res[left] = res[left] ^ res[right];
            right--;
            left++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
