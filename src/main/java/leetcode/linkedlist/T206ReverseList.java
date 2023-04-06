/**
 * 206. Reverse Linked List
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/"></a>
 */
package leetcode.linkedlist;

import leetcode.datastructure.LinkedList;
import leetcode.datastructure.ListNode;

public class T206ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while(cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5};
        LinkedList ls = new LinkedList();
        ls.buildAsList(list);
        System.out.println(ls);
        ListNode newHead = reverseList(ls.getHead());
        System.out.println(newHead);
    }
}
