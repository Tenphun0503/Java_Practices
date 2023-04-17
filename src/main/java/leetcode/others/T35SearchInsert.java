/**
 * @see <a href=""></a>
 */
package leetcode.others;

public class T35SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }

        }

        return nums[mid] > target ? mid: mid + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }
}
