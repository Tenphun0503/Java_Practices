/**
 * 141. Linked List Cycle
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/"></a>
 */
package leetcode.twopointers;

import leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class T141HasCycle {

    /**
     * Two pointers, one moves by 1 step, another 2 step. If there is a cycle, they will meet sometime
     * @param head: input
     * @return res: if linked list has cycle
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    /**
     * Use Hashmap
     * @param head: input head of linked list
     * @return res: to see if linked list cause cycle
     */
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(hasCycle1(n1));
    }
}
