/**
 * 1768. Merge Strings Alternately
 * @see <a href="https://leetcode.com/problems/merge-strings-alternately/"></a>
 */
package leetcode.others;

public class T1768MergeAlternately {
    public static String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i< word1.length() && j<word2.length()){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        if(i<word1.length())sb.append(word1.substring(i));

        if(j<word2.length())sb.append(word2.substring(j));
        return sb.toString();

    }


    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";
        System.out.println(mergeAlternately(word1,word2));
    }
}
