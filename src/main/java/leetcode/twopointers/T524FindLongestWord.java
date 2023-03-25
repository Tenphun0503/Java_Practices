/**
 * 524. Longest Word in Dictionary through Deleting
 *
 * @see <a href="https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/"></a>
 */
package leetcode.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T524FindLongestWord {
    /**
     * To see if a dic is substring of s
     */
    public static boolean findWord(String s, String dic) {
        int i = 0, j = 0;
        while (i < s.length() && j < dic.length()) {
            if (s.charAt(i) != dic.charAt(j)) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        return j == dic.length();
    }

    /**
     * first sort the dictionary and then look for first one result
     */
    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s2.length() - s1.length(); // Longer strings come first
            } else {
                return s1.compareTo(s2); // Sort by lexicographical order
            }
        });
        for (String dic : dictionary) {
            boolean res = findWord(s, dic);
            if (res) return dic;
        }
        return "";
    }

    /**
     * compare all in dictionary that fits more than longestWord
     * Better on time complexity
     */
    public static String findLongestWord2(String s, List<String> dictionary) {
        String longestword = "";
        for (String dic : dictionary) {
            int l1 = longestword.length(), l2 = dic.length();
            if (l1 > l2 || l1 == l2 && longestword.compareTo(dic) < 0) {
                continue;
            }
            if (findWord(s, dic)) {
                longestword = dic;
            }
        }
        return longestword;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord(s, dictionary));
        System.out.println(findLongestWord2(s, dictionary));
    }
}
