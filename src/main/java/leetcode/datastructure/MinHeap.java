/**
 * This class implement a min-heap class
 */
package leetcode.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap extends BinaryTree {
    public void insert(int val) {
        treeList.add(val);
        int index = treeList.size() - 1;
        while (val < treeList.get((index - 1) / 2) && index != 0) {
            Collections.swap(treeList, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    @Override
    public void buildAsList(Integer[] list) {
        for (int val: list){
            insert(val);
        }
        super.buildAsList(treeList.toArray(new Integer[treeList.size()]));
    }


    public int deleteMin() {
        int res;
        if (treeList.size() == 1){
            return treeList.remove(0);
        }else {
            Collections.swap(treeList, treeList.size() - 1, 0);
            res = treeList.remove(treeList.size() - 1);
            heapifyDown(0);
            return res;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;
        int size = treeList.size();

        if (leftChild < size && treeList.get(leftChild) < treeList.get(smallest)) {
            smallest = leftChild;
        }

        if (rightChild < size && treeList.get(rightChild) < treeList.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != index) {
            Collections.swap(treeList, index, smallest);
            heapifyDown(smallest);
        }

    }

    public static void main(String[] args) {
        MinHeap m = new MinHeap();
        Integer[] list = {1, 3, 5, 9, 8, 14, 7, 10, 18};

        System.out.println(m.treeList);
        m.buildAsList(list);
        System.out.println(m.treeList);
        System.out.println(m);

        m.insert(4);
        System.out.println(m.treeList);

        System.out.println(m.deleteMin());
        System.out.println(m.treeList);
    }

}
