/**
 * This class implement a min-heap class
 */
package leetcode.datastructure;

import java.util.Collections;

public class MinHeap extends BinaryTree {
    public void insert(int val) {
        treeList.add(val);
        int index = treeList.size() - 1;
        while (val < treeList.get((index - 1) / 2) && index != 0) {
            Collections.swap(treeList, index, (index - 1) / 2);
            index = (index-1)/2;
        }
    }

    public int deleteMin() {
        int res;
        Collections.swap(treeList, treeList.size() - 1, 0);
        res = treeList.remove(treeList.size() - 1);
        int index = 0;
        while ((treeList.get(index) > treeList.get(index * 2 + 1) || treeList.get(index) > treeList.get(index * 2 + 2))&&index<treeList.size()) {
            System.out.println(index);
            if (treeList.get(index) > treeList.get(index * 2 + 1) && !(treeList.get(index) > treeList.get(index * 2 + 2))){
                Collections.swap(treeList, index, index * 2 + 1);
                index = index*2+1;
            }
            if (!(treeList.get(index) > treeList.get(index * 2 + 1)) && treeList.get(index) > treeList.get(index * 2 + 2)){
                Collections.swap(treeList, index, index * 2 + 2);
                index = index*2+2;
            }
            if (treeList.get(index) > treeList.get(index * 2 + 1) && treeList.get(index) > treeList.get(index * 2 + 2)) {
                if (treeList.get(index * 2 + 1) <= treeList.get(index * 2 + 2)){
                    Collections.swap(treeList, index, index * 2 + 1);
                    index = index*2+1;
                }
                else{
                    Collections.swap(treeList, index, index * 2 + 2);
                    index = index*2+2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinHeap m = new MinHeap();
        Integer[] list = {1,3,5,9,8,14,7,10,18};
        m.buildAsList(list);
        System.out.println(m.treeList);

        m.insert(4);
        System.out.println(m.treeList);

        System.out.println(m.deleteMin());
        System.out.println(m.treeList);

    }

}
