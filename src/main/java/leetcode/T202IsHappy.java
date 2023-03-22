/**
 * 202. Happy Number
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class T202IsHappy {
    public static int sumOfDigitSqr(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    public static boolean isHappy(int n) {
        boolean res;
        int step = sumOfDigitSqr(n);
        Set<Integer> record = new HashSet<>();
        while (step != 1 && !record.contains(step)){
            record.add(step);
            step = sumOfDigitSqr(step);
        }
        return step==1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));;
    }
}
