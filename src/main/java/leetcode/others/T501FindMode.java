/**
 * 501. Find Mode in Binary Search Tree
 * @see <a href="https://leetcode.com/problems/find-mode-in-binary-search-tree/"></a>
 */
package leetcode.others;

import leetcode.datastructure.BinaryTree;
import leetcode.datastructure.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T501FindMode {
    public static <K, V extends Comparable<V>> K getKeyOfMaxValue(Map<K, V> map) {
        K keyOfMaxValue = null;
        V maxValue = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (maxValue == null || entry.getValue().compareTo(maxValue) > 0) {
                maxValue = entry.getValue();
                keyOfMaxValue = entry.getKey();
            }
        }
        return keyOfMaxValue;
    }
    public static int[] findMode(TreeNode root) {
        int[] res = {0};
        BinaryTree bt = new BinaryTree(root);
        List<Integer> inorder = bt.inOrderTraversal();
        int[][] f = new int[inorder.size()][];
        int i = 0;
        return res;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Integer[] list = {1, null, 2, null, null, 2};
        bt.buildAsList(list);
        System.out.println(bt.inOrderTraversal());
    }

}
