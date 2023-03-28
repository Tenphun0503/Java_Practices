/**
 * This class implement a binary tree node
 */
package leetcode.datastructure;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){
    }

    public TreeNode(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
