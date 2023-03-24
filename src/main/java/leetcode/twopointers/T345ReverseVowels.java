/**
 * 345. Reverse Vowels of a String
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/"></a>
 */
package leetcode.twopointers;

import java.util.*;

public class T345ReverseVowels {
    private final static List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    /**
     * Reverse all the vowels in a string
     * @param s: input String
     * @return res: reversed String
     */
    public static String reverseVowels(String s){
        if (s == null) return null;
        int left = 0, right = s.length() - 1;
        char[] res = s.toCharArray();
        while (left <= right){
            char cLeft = res[left];
            char cRight = res[right];
            if (!vowel.contains(cLeft)){
                res[left++] = cLeft;
            } else if(!vowel.contains(cRight)){
                res[right--] = cRight;;
            } else{
                res[left++] = cRight;
                res[right--] = cLeft;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "Asa";
        System.out.println(reverseVowels(s));
    }
}
/*
* leetcode
* leotcede
*/