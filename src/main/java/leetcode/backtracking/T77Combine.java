/**
 * @see <a href=""></a>
 */
package leetcode.backtracking;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T77Combine {
    private static int K;
    private static int N;
    public static List<List<Integer>> combine(int n, int k) {
        N = n;
        K = k;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= N; i++){
            for (List<Integer> e : path(i, 1)){
                e.add(0, i);
                res.add(e);
            }
        }
        return res;
    }
    private static List<List<Integer>> path(int cur, int k){
        List<List<Integer>> res = new ArrayList<>();
        if(k == K) {
            res.add(new ArrayList<>());
            return res;
        }
        k++;
        for (int i = cur + 1; i <= N; i++){
            for (List<Integer> e : path(i, k)){
                e.add(0, i);
                res.add(e);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
