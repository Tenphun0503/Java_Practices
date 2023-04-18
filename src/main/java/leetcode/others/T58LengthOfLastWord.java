/**
 * 58. Length of Last Word
 * @see <a href="https://leetcode.com/problems/length-of-last-word/"></a>
 */
package leetcode.others;

public class T58LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] list = s.split(" ");
        return list[list.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

}
