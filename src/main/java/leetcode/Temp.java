/**
 * @see <a href=""></a>
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Temp {
    public static void main(String[] args) {
        int[] input = {1,2,3,2,3,0,2};
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> Integer.compare(o2,o1));
        for (int i : input){
            set.add(i);
        }
        int[] res = new int[]{set.pollFirst(), set.pollFirst()};
        System.out.println(Arrays.toString(res));
    }
}
