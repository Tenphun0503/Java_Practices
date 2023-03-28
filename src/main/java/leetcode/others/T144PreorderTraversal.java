/**
 * 144. Valid Palindrome II
 *
 * @see <a https://leetcode.com/problems/binary-tree-preorder-traversal/"></a>
 */
package leetcode.others;

import leetcode.datastructure.BinaryTree;
import leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T144PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private static void preorderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            preorderTraversal(node.left, res);
            preorderTraversal(node.right, res);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {1, null, 2, null, null, 3};
        BinaryTree bt = new BinaryTree();
        bt.buildAsList(list);
        System.out.println(bt);
        List<Integer> res = preorderTraversal(bt.root);
        System.out.println(res);
    }
}
