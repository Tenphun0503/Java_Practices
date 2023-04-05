/**
 * 14. Longest Common Prefix
 * @See <a href="https://leetcode.com/problems/longest-common-prefix/"></a>
 */
package leetcode.others;

public class T14LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = commonPrefix(res, strs[i]);
            if(res=="")break;
        }
        return res;
    }

    private static String commonPrefix(String res, String str) {
        int i = 0;
        while (i<res.length() && i<str.length()){
            if(res.charAt(i)==str.charAt(i))i++;
            else break;
        }
        return res.substring(0,i);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        //System.out.println(commonPrefix(strs[0], strs[1]));
    }
}
