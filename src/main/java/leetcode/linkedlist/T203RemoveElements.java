/**
 * 203. Remove Linked List Elements
 * @see <a href="https://leetcode.com/problems/remove-linked-list-elements/"></a>
 */
package leetcode.linkedlist;

import leetcode.datastructure.LinkedList;
import leetcode.datastructure.ListNode;

public class T203RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(val-1);
        newHead.next = head;
        ListNode node = newHead;
        while(node.next!=null && node.next.next!=null){
            if(node.next.val == val) node.next = node.next.next;
            else node = node.next;
        }
        if(node.next!=null && node.next.val == val)node.next = null;
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] list = {1,2,6,3,4,5,6};
        LinkedList linkedList = new LinkedList();
        linkedList.buildAsList(list);
        System.out.println(linkedList);
        ListNode head = removeElements(linkedList.getHead(), 6);
        System.out.println(head);
    }
}
