/**
 * 59. Spiral Matrix II
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/description/"></a>
 */
package leetcode.others;

public class T59GenerateMatrix {
    static int[][] matrix;

    private static int generateMatrix(int n, int start, int last) {
        for (int i = start; i <= start + n - 1; i++) {
            matrix[start][i] = i + last;
        }
        for (int i = start; i <= start + n - 1; i++) {
            matrix[i][start + n - 1] = n - 1 + i + last;
        }
        int index = 0;
        for (int i = n - 1 + start; i >= 0; i--) {
            matrix[start + n - 1][i] = 2 * (n - 1) + (index) + last;
            index ++;
        }
        index = 0;
        for (int i = n - 1 + start; i >= 1; i--) {
            matrix[i][start] = 3 * (n - 1) + (index++) + last;
        }
        return last + (4 * n - 5);
    }

    public static int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        int start = 0, last = 1;
        while (n > 0) {
            last = generateMatrix(n, start, last);
            start += 1;
            n-=2;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] m = generateMatrix(5);
        for (int[] x : m) {
            for (int y : x) {
                System.out.print(y+"\t");
            }
            System.out.println("");
        }
    }
}
