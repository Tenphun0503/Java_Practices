/**
 * 167. Two Sum II - Input Array Is Sorted
 * @see <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/></a>
 */
package leetcode.twopointers;

import java.util.Arrays;

public class T167TwoSum {
    /**
     * Find the index of two numbers that sum of them is target.
     * @param numbers: a sorted array of numbers range from [-1000, 1000]
     * @param target: the target sum we want
     * @return res: index of two numbers whose sum is target
     */
    public static int[] twoSum(int[] numbers, int target){
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left != right){
            if (numbers[left] + numbers[right] < target){
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(numbers, 6)));
    }

}
