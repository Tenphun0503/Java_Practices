/**
 * 28. Find the Index of the First Occurrence in a String
 * @see <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/"></a>
 */
package leetcode.others;

public class T28StrStr {
    public static int strStr(String haystack, String needle) {
        int length = needle.length();
        for (int i = 0; i < haystack.length() - length+1; i++){
            if(needle.equals(haystack.substring(i,i+length))){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "adbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }
}
