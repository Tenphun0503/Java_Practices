/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * @see <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/"></a>
 */
package leetcode.others;

import leetcode.datastructure.BinaryTree;
import leetcode.datastructure.TreeNode;

public class T1372LongestZigZag {
    private final int RIGHT = 0;
    private final int LEFT = 1;
    private int MAX = 0;
    public int longestZigZag(TreeNode root) {
        longestZigZag(root, RIGHT, 0);
        longestZigZag(root, LEFT, 0);
        return MAX;
    }
    private void longestZigZag(TreeNode node, int direct, int steps){
        if (node==null) return;

        MAX = Math.max(MAX, steps);

        if(direct==RIGHT){
            longestZigZag(node.right, LEFT, steps+1);
            longestZigZag(node.left, RIGHT, 1);
        }else{
            longestZigZag(node.left, RIGHT, steps+1);
            longestZigZag(node.right, LEFT, 1);
        }
    }



    public static void main(String[] args) {
        Integer[] list = {1,1,1,null,1,null,null,1,1,null,1};
        BinaryTree bt = new BinaryTree();
        bt.buildAsList(list);
        System.out.println(bt);
    }
}
