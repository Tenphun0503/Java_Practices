/**
 * This class implement Node for linked list
 */
package leetcode.datastructure;

public class ListNode {
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val).append(" ");
        ListNode node = this.next;
        while(node!=null){
            sb.append(node.val).append(" ");
            node = node.next;
        }

        return sb.toString();
    }
}
