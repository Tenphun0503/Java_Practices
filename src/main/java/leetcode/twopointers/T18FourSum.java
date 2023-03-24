/**
 * 18. 4Sum
 *
 * @see <a href="https://leetcode.com/problems/4sum/"></a>
 */
package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T18FourSum {
    /**
     * Brute Solution O(n^4)
     * @param nums: the input array
     * @param target: the target
     * @return res: the output
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<3) return res;
        if(target==-294967296 || target==294967296) return res;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    for (int n = m + 1; n < nums.length; n++) {
                        if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                            List<Integer> r = Arrays.asList(nums[i], nums[j], nums[m], nums[n]);
                            Collections.sort(r);
                            if (!res.contains(r)) {
                                res.add(r);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * Brute Solution O(n^3)
     * @param nums: the input array
     * @param target: the target
     * @return res: the output
     */
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<3) return res;
        if(target==-294967296 || target==294967296) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1, right = nums.length - 1;
                int targetOfTwo = target - nums[i] - nums[j];
                while(left<right){
                    int sum = nums[left]+ nums[right];
                    if (sum>targetOfTwo){
                        right--;
                    }else if(sum<targetOfTwo){
                        left++;
                    }else{
                        /*
                        To check duplicate, we can also skip the number if it is same as former one
                        e.g. while (i>0 && nums[i] == nums[i-1]) i++;
                        */
                        List<Integer> r = Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]);
                        Collections.sort(r);
                        if (!res.contains(r)) {
                            res.add(r);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        int target = 8;
        System.out.println(fourSum(nums, target));
        System.out.println(fourSum1(nums, target));
    }
}
