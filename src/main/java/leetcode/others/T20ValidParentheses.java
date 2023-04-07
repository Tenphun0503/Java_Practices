/**
 * @See <a href=""></a>
 */
package leetcode.others;

import leetcode.datastructure.Stack;

import java.util.HashMap;
import java.util.Map;


public class T20ValidParentheses {
    private static boolean isLeft(char sample){
        char[] lefts = {'{', '[', '('};
        for(char l:lefts){
            if(l==sample)return true;
        }
        return false;
    }
    public static boolean isValid(String s) {
        char[] set = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();
        for(char c: set){
            if(isLeft(c)) stack.push(c);
            else{
                if(stack.isEmpty()) return false;
                Character character = stack.pop();
                if(map.get(character)!=c)return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[{}}}{}]";
        System.out.println(isValid(s));
    }
}
