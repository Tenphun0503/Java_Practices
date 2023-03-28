/**
 * This class implement a Binary Tree
 * Methods: in-order, pre-order, post-order, level-order traversal, buildAsList, toString
 * TODO: special case check
 */
package leetcode.datastructure;

import java.util.*;
import java.util.LinkedList;

public class BinaryTree {
    public TreeNode root;
    public List<Integer> treeList = new ArrayList<>();

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
        this.treeList.add(root.val);
    }

    public List<Integer> inOrderTraversal() {
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            inOrderTraversal(node.left, res);
            res.add(node.val);
            inOrderTraversal(node.right, res);
        }
    }

    public List<Integer> preOrderTraversal() {
        List<Integer> res = new ArrayList<>();
        preOrderTraversal(root, res);
        return res;
    }

    private void preOrderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            preOrderTraversal(node.left, res);
            preOrderTraversal(node.right, res);
        }
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(root, res);
        return res;
    }

    private void postOrderTraversal(TreeNode node, List<Integer> res) {
        if (node != null) {
            postOrderTraversal(node.left, res);
            postOrderTraversal(node.right, res);
            res.add(node.val);
        }
    }

    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    result.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    result.add(null);
                }
            }
        }

        while (result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        this.treeList = result;
        return result;
    }

    public void buildAsList(Integer[] list) {
        this.treeList.clear();
        this.treeList.addAll(Arrays.asList(list));
        this.root = buildAsList(0, list);
    }

    private TreeNode buildAsList(int rootIndex, Integer[] list) {
        int length = list.length;
        if (length == 0) return null;
        TreeNode current = new TreeNode();
        if (list[rootIndex] != null) current.val = list[rootIndex];
        if (rootIndex * 2 + 1 < length && list[rootIndex * 2 + 1] != null)
            current.left = buildAsList(rootIndex * 2 + 1, list);
        if (rootIndex * 2 + 2 < length && list[rootIndex * 2 + 2] != null)
            current.right = buildAsList(rootIndex * 2 + 2, list);
        return current;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTree (left child comes above right child)\n");
        printTree(sb, "", root, false, root.right == null);
        return sb.toString();
    }

    private void printTree(StringBuilder sb, String prefix, TreeNode node, boolean isLeft, boolean isRightChildNull) {
        if (node != null) {
            sb.append(prefix);
            sb.append(isLeft && !isRightChildNull ? "├── " : "└── ");
            sb.append(node.val);
            sb.append("\n");

            printTree(sb, prefix + (isLeft ? "│   " : "    "), node.left, true, node.right == null);
            printTree(sb, prefix + (isLeft ? "│   " : "    "), node.right, false, node.right == null);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {2, 3, 4, 5, null, 7, 8};
        BinaryTree t = new BinaryTree();
        t.buildAsList(list);
        System.out.println(t);
        System.out.println(t.preOrderTraversal());
        System.out.println(t.inOrderTraversal());
        System.out.println(t.postOrderTraversal());
        System.out.println(t.levelOrderTraversal());
    }
}
