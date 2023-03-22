package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T1002CommonChars {
    public static void printHash(int[] hash){
        String line = "";
        for (int j : hash) {
            line += j + " ";
        }
        System.out.println(line);
    }
    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 0){
            return res;
        }
        int[] hash = new int[26];

        // init hash
        for(int i=0; i<words[0].length(); i++){
            hash[words[0].charAt(i) - 'a']++;
        }
        // compare hash and choose min
        for (int i=1; i<words.length; i++){
            int[] hashTwo = new int[26];
            for (int j=0;j<words[i].length(); j++){
                hashTwo[words[i].charAt(j)-'a']++;
            }

            for(int j=0; j<26;j++){
                hash[j] = Math.min(hash[j], hashTwo[j]);
            }
        }

        printHash(hash);
        // combine result
        for(int i=0; i<26; i++){
            while (hash[i]>0){
                char tmp = (char) (i + 'a');
                res.add(String.valueOf(tmp));
                hash[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        List<String> res = commonChars(words);
        System.out.println(res);
    }
}
