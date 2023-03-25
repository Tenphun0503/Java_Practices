/**
 * 680. Valid Palindrome II
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/"></a>
 */
package leetcode.twopointers;

public class T680ValidPalindrome {
    /**
     * a general valid palindrome function
     */
    public static boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * we can delete up to 1 character
     *
     * @param s: input
     * @return res: see if s is palindrome
     */
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(i) != s.charAt(j)) {
                return (valid(s, i, j - 1) || valid(s, i + 1, j));
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }
}
