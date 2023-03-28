/**
 * This class implement quickSort
 */
package leetcode.sort;

import java.util.Arrays;

public class QuickSort {
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int partition(int[] A, int p, int q) {
        int i = p, j = q+1;
        while (true) {
            while (A[++i] < A[p] && i<q);
            while(A[--j] > A[p] && j>p);
            if (i >= j) break;
            swap(A, i, j);
        }
        swap(A, p, j);
        return j;
    }

    public void quickSort(int[] A){
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int p, int q) {
        if (p < q) {
            int r = partition(A, p, q);    // the index where the partitioning element lands
            quickSort(A, p, r - 1);     // now A[p:r-1] is sorted, and all are <= a
            quickSort(A, r + 1, q);     // now A[r+1:q] is sorted, and all are > a
        }
    }

    public static void main(String[] args) {
        int[] a = {3,4,5,2};
        QuickSort q = new QuickSort();
        q.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
