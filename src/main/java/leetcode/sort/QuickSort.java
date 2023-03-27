/**
 * QuickSort.java
 */
package leetcode.sort;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int partition(int[] A, int p, int q) {
        int i = p, j = q;
        int a = A[p]; // the partitioning element
        while (i < j) {
            while (A[i] <= a && i < q) i++;
            while (A[j] > a && j > p) j--;
            if (i < j) swap(A, i++, j--);
        }
        swap(A, p, j);
        return j;
    }

    public static void quickSort(int[] A, int p, int q) {
        int r;
        if (p < q) {
            r = partition(A, p, q);        // the index where the partitioning element lands
            quickSort(A, p, r - 1);     // now A[p:r-1] is sorted, and all are <= a
            quickSort(A, r + 1, q);     // now A[r+1:q] is sorted, and all are > a
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 3, 6, 8, 7, 5};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
