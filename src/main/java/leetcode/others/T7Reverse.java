/**
 * 7. Reverse Integer
 * @see <a href="https://leetcode.com/problems/reverse-integer/"></a>
 */
package leetcode.others;

import leetcode.datastructure.Stack;

public class T7Reverse {
    /*
        32-bit signed two's complement integer
        Range: -2,147,483,648 to 2,147,483,647.
     */

    public static int reverse(int x) {
        if(x==0)return 0;
        Stack<Integer> stack = new Stack<>();
        int sign = x<0 ? -1 : 1;

        while(x!=0){
            int d = x % 10;
            stack.push(d*sign);
            x = x / 10;
        }

        int res = stack.pop();
        int a = 10;
        while(!stack.isEmpty()){
            int remain = 2147483647 - res;
            if(a==1000000000){
                if (stack.peek()>2)return 0;
            }
            int adding = stack.pop()*a;
            if(sign==-1 && remain+1<adding)return 0;
            if(sign==1 && remain<adding) return 0;
            res += adding;
            a *=10;
        }

        return res*sign;

    }

    /*
        solution
     */
    public static int reverse2(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int num = 2147483647;
        System.out.println(reverse(num));
        System.out.println(reverse2(num));
    }

}
