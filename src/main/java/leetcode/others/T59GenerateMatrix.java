/**
 * 59. Spiral Matrix II
 *
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii/description/"></a>
 */
package leetcode.others;

public class T59GenerateMatrix {
    static int[][] matrix;


    /**
     * We build the matrix layer by layer from the out to inner.
     * for example: for the matrix below
     *      1	2	3	4	5
     *      16	17	18	19	6
     *      15	24	25	20	7
     *      14	23	22	21	8
     *      13	12	11	10	9
     * we build 1-16, then 17-24, then 25: which is, build an n=5 circle, then n=3, then n=1; (n-=2)
     * for each layer, we need to determine something
     *      1. the size `n`, e.g. n = 5
     *      2. the index of top-left element, which is the start of the matrix `start`, e.g. start = 0
     *      3. the starting value `last`, e.g. last = 1
     *       1	2	3	4	5
     *       16	        	6
     *       15	        	7
     *       14	        	8
     *       13	12	11	10	9
     * We can build each layer like this:
     *      1. for M[0][0:n-1]      we put  (0:n-1)+last
     *      2. for M[0:n-1][n-1]    we put  (n-1:2n-2)+last
     *      3. for M[n-1][n-1:0]    we put  (2n-2:3n-3)+last
     *      4. for M[n-1:0][1]      we put  (3n-3:4n-5)+last
     * Consider the start of the matrix, e.g. 2ed layer moves right by one and down by one. which becomes [start][start]
     * Last can be considered as last element of the last layer
     *
     */
    private static int generateMatrix(int n, int start, int last) {
        for (int i = start; i <= start + n - 1; i++) {
            matrix[start][i] = i + last;
        }
        for (int i = start; i <= start + n - 1; i++) {
            matrix[i][start + n - 1] = n - 1 + i + last;
        }
        int index = start;
        for (int i = n - 1 + start; i >= start; i--) {
            matrix[start + n - 1][i] = 2 * (n - 1) + (index) + last;
            index ++;
        }
        index = start;
        for (int i = n - 1 + start; i >= 1 + start; i--) {
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
            System.out.println();
        }
    }
}
