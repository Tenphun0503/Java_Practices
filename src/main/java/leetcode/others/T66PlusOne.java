/**
 * 66. Plus One
 * @see <a href="https://leetcode.com/problems/plus-one/"></a>
 */
package leetcode.others;

import java.util.Arrays;

public class T66PlusOne {
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int[] res = new int[digits.length + 1];
        for (int i = res.length - 1; i >= 0; i--) {
            int adder = 0;
            if(i - 1 >= 0) adder = digits[i - 1];

            res[i] = adder + carry;
            if (res[i] >= 10){
                carry = 1;
                res[i] -= 10;
            }else{
                carry = 0;
            }
        }

        if (res[0] == 0) return Arrays.copyOfRange(res, 1, res.length);
        else return res;
    }

    public static void main(String[] args) {
        int[] digits = {4,3};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
