/**
 * 19. Remove Nth Node From End of List
 *
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/"></a>
 */
package leetcode.linkedlist;

import leetcode.datastructure.LinkedList;
import leetcode.datastructure.ListNode;

public class T19RemoveNthFromEnd {
    /*
        Two passes
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(0);
        p.next = head;
        int size = 0;
        ListNode node = head;
        while(node != null){
            size ++;
            node = node.next;
        }
        int index = size - n;
        if (size==1)return null;
        node = p;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return p.next;
    }

    /*
        One pass, use two pointers
     */
    public static ListNode removeNth(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] list = {1,2};
        LinkedList ls = new LinkedList();
        ls.buildAsList(list);
        int n = 2;
        System.out.println(removeNthFromEnd(ls.getHead(), n));
        System.out.println(removeNth(ls.getHead(), n));
    }
}
