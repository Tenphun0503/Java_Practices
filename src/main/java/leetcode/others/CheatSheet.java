/**
 * @see <a href=""></a>
 */
package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheatSheet {
    public static void main(String[] args) {
        // Create a list of integer, primitive type
        int[] ints = new int[10];
        // Create a list of integer
        Integer[] integers = new Integer[10];
        // Create an array of integer
        List<Integer> integerList = new ArrayList<>();

        // ints -> integers
        Arrays.stream(ints).boxed().toArray(Integer[]::new);
        // integers -> ints
        Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        // integers -> integerList
        Arrays.asList(integers);
        // integerList -> integers
        integerList.toArray(new Integer[0]);
    }
}
