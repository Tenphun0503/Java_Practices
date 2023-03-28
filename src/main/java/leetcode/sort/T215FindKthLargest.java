/**
 * 215. Kth Largest Element in an Array
 *
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/"></a>
 */
package leetcode.sort;

import leetcode.datastructure.MinHeap;
import leetcode.datastructure.TreeNode;

import java.util.Arrays;

public class T215FindKthLargest {
    /**
     * Using mean-heap, not the best way
     */
    private static int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;
        MinHeap mh = new MinHeap();
        mh.buildAsList(Arrays.stream(nums).boxed().toArray(Integer[]::new));
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = mh.deleteMin();
        }
        return res;
    }

    /**
     * Using  min-heap, but keep only k node with the largest values
     */
    private static int findKthLargest2(int[] nums, int k) {
        MinHeap mh = new MinHeap(new TreeNode(nums[0]));

        for (int i = 1; i < k; i++) {
            mh.insert(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > mh.treeList.get(0)) {
                mh.deleteMin();
                mh.insert(nums[i]);
            }
        }
        return mh.treeList.get(0);
    }

    /**
     * Using quick sort, O(n)
     * sort from the largest to the smallest
     */
    public static int findKthLargest3(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        int[] nums = {3, 4,5,2};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
        System.out.println(findKthLargest2(nums, k));
        System.out.println(findKthLargest3(nums, k));
    }
}
