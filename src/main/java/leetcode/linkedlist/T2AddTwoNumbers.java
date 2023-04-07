/**
 * 2. Add Two Numbers
 * @see <a href="https://leetcode.com/problems/add-two-numbers/"></a>
 */
package leetcode.linkedlist;

import leetcode.datastructure.LinkedList;
import leetcode.datastructure.ListNode;

public class T2AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);

    }

    private static ListNode add(ListNode node1, ListNode node2, int a) {
        if(node1==null && node2==null){
            if(a==1) return new ListNode(a);
            else return null;
        }
        if (node1==null) node1= new ListNode(0);
        if (node2==null) node2= new ListNode(0);
        int sum = node1.val + node2.val + a;
        if (sum>=10){
            sum-=10;
            a = 1;
        }else{
            a = 0;
        }
        node1.val = sum;
        node1.next = add(node1.next, node2.next, a);
        return node1;
    }

    public static void main(String[] args) {
        int[] l1 = {9,9,9,9,9,9,9};
        int[] l2 = {9,9,9,9};
        LinkedList ls1 = new LinkedList();
        LinkedList ls2 = new LinkedList();
        ls1.buildAsList(l1);
        ls2.buildAsList(l2);
        System.out.println(addTwoNumbers(ls1.getHead(), ls2.getHead()));
    }

}
