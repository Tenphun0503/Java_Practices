/**
 * 1207. Unique Number of Occurrences
 * @see <a href="https://leetcode.com/problems/unique-number-of-occurrences/"></a>
 */
package leetcode.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class T1207UniqueOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return set.size()==map.size();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }
}
