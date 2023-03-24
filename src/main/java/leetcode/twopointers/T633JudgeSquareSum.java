/**
 * 633. Sum of Square Numbers
 * @see <a href="https://leetcode.com/problems/sum-of-square-numbers/"></a>
 */
package leetcode.twopointers;

public class T633JudgeSquareSum {
    /**
     * Decide if c can be the form of a^2 + b^2
     * @param c: the input number
     * @return res: true or false
     */
    public static boolean judgeSquareSum(int c){
        if (c < 0) return false;
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right){
            long mul = right * right + left * left;
            if (mul > c){
                right --;
            } else if (mul < c) {
                left ++;
            } else{
                return true;
            }
        }
        return false;
    }

    /**
     * We used two pointers above, this time we compute sqrt(c-a^2) and see if b==(int)b
     * @param c: the input number
     * @return res: true or false
     */
    public static boolean judgeSquareSum2(int c){
        for (int a = 0; a <= Math.sqrt(c); a++){
            double b = Math.sqrt(c - a * a);
            if (b == (int)b){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 2147483600;
        System.out.println(judgeSquareSum(c));
        System.out.println(judgeSquareSum2(c));
    }
}
