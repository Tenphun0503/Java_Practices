/**
 * 524. Longest Word in Dictionary through Deleting
 * @see <a href="https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/"></a>
 */
package leetcode.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T524FindLongestWord {
    public static String findLongestWord(String s, List<String> dictionary) {
         Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length(); // Longer strings come first
                } else {
                    return s1.compareTo(s2); // Sort by lexicographical order
                }
            }
        });
        System.out.println(dictionary);
        return "";
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");
        System.out.println(findLongestWord(s, dictionary));
    }
}
