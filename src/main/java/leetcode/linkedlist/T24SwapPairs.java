/**
 * 24. Swap Nodes in Pairs
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/"></a>
 */
package leetcode.linkedlist;

import leetcode.datastructure.LinkedList;
import leetcode.datastructure.ListNode;

public class T24SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        return swap(head);
    }
    private static ListNode swap(ListNode head){
        if(head == null || head.next==null) return head;
        ListNode tmp = head.next;
        head.next = swap(tmp.next);
        tmp.next = head;
        return tmp;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4};
        LinkedList ls = new LinkedList();
        ls.buildAsList(list);
        System.out.println(ls);
        System.out.println(swapPairs(ls.getHead()));
    }
}
