/**
 * @see <a href=""></a>
 */
package leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class T242IsAnagram {
    // use frequent counting
    public static boolean isAnagram1(String s, String t){
        if(s.length()!=t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for (int i : count) {
            if(i!=0)return false;
        }
        return true;
    }

    // use hashMap
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        System.out.println(map);

        for (char c : t.toCharArray()) {
            if(!map.containsKey(c)) return false;
            else if (map.get(c)==0) return false;
            else map.put(c, map.get(c)-1);
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()!=0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s, t));
    }

}
