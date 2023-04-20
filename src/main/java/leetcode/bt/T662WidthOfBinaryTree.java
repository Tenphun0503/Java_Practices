/**
 * 662. Maximum Width of Binary Tree
 *
 * @see <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/"></a>
 */
package leetcode.bt;

import leetcode.datastructure.BinaryTree;
import leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Map;

public class T662WidthOfBinaryTree {
    class Pair<K, V>{
        K key;
        V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        K getKey(){
            return key;
        }
        V getValue(){
            return value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        // queue of elements [(node, col_index)]
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth = 0;

        queue.addLast(new Pair<>(root, 0));
        while (queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();

            // iterate through the current level
            Integer currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;
            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                if (node.left != null)
                    queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                if (node.right != null)
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
            }

            // calculate the length of the current level,
            //   by comparing the first and last col_index.
            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        Integer[] list = {1, 3, 2, 5, null, null, 9, 6, null, null, null, null, null, 7, null};
        BinaryTree bt = new BinaryTree();
        bt.buildAsList(list);
        T662WidthOfBinaryTree s = new T662WidthOfBinaryTree();
        System.out.println(s.widthOfBinaryTree(bt.root));
    }
}
