/**
 * 1046. Last Stone Weight
 * @see <a href="https://leetcode.com/problems/last-stone-weight/"></a>
 */
package leetcode.others;

import java.util.*;

public class T1046LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        if (stones.length==1) return stones[0];

        while(stones.length>1){
            Arrays.sort(stones);
            int e = stones[stones.length - 1] - stones[stones.length - 2];
            System.out.println(Arrays.toString(stones) + " " + e);
            if (e==0){
                stones = Arrays.copyOfRange(stones, 0, stones.length - 2);
            }else{
                stones = Arrays.copyOfRange(stones, 0, stones.length - 1);
                stones[stones.length - 1] = e;
            }
        }
        return stones.length==1 ? stones[0] : 0;
    }


    public int solution (int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
