/**
 * 704. Binary Search
 *
 * @see <a https://leetcode.com/problems/binary-search/"></a>
 */
package leetcode.others;

public class T704Search {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return search(nums, left, right, target);
    }

    private static int search(int[] nums, int left, int right, int target){
        int mid = (right + left) / 2;
        if (left > right) return -1;
        if (nums[mid] == target) return mid;
        else if (nums[mid] >= target) return search(nums, left, mid-1, target);
        else return search(nums, mid+1, right, target);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 5));
    }
}
