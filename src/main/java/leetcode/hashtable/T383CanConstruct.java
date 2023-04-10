/**
 * https://leetcode.com/problems/ransom-note/
 * @see <a href="383. Ransom Note"></a>
 */
package leetcode.hashtable;

import java.util.HashMap;

public class T383CanConstruct {
    public static boolean canConstruct(String ransomNote, String magazine) {
        // ransomNote n; magazine m;
        // build map: O(m)
        // traversal note: O(m) since we pass the keys not in the map (worst case n<=m)
        // Time Complexity O(m) Space Complexity O(k)=O(1) where k<=26
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c:magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c:ransomNote.toCharArray()){
            if(!map.containsKey(c)) return false;
            else if (map.get(c)==0) return false;
            else map.put(c, map.get(c)-1);
        }

        return true;
    }

    public static void main(String[] args) {
        String note = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(note, magazine));

    }
}
