/**
 * This class implement class of linked list
 * TODO: Insertion, Deletion, Contains,
 */
package leetcode.datastructure;

public class LinkedList {
    public ListNode head;
    private int length;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(int val) {
        this.head = new ListNode(val);
    }

    /**
     * build the linked list according to the int list
     * @param list: input
     */
    public void buildAsList(int[] list) {
        this.length = list.length;
        this.head = new ListNode(list[0]);
        ListNode current = this.head;
        for (int i = 1; i < this.length; i++) {
            ListNode node = new ListNode(list[i]);
            current.next = node;
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList{");
        ListNode current = this.head;
        while (current != null) {
            res.append(current.val);
            res.append(", ");
            current = current.next;
        }
        res.append("Length:");
        res.append(this.length);
        res.append("}");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] list = {3,2,0,-4};
        LinkedList linkedList = new LinkedList();
        linkedList.buildAsList(list);
        System.out.println(linkedList);
    }
}
