/**
 * This class implement heapsort
 */
package leetcode.sort;

import leetcode.datastructure.MinHeap;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] A){
        MinHeap mh = new MinHeap();
        mh.buildAsList(Arrays.stream(A).boxed().toArray(Integer[]::new));
        for(int i = 0; i < A.length; i++){
            A[i] = mh.deleteMin();
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 6, 8, 7, 5};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

}
