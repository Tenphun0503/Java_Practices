/**
 * LinkedList.java
 * Author: Ten phun
 * This class implement single linked list
 * Methods:
 * GetHead(), GetSize(), isEmpty(), clean(), get(i), addAt(i, v), addAtHead(v), addAtTail(v), deleteAt(i), buildAsList(list)
 */
package leetcode.datastructure;

public class LinkedList {
    private final ListNode head;
    private int size;   // sentinel node as pseudo-head

    public LinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public ListNode getHead() {
        return head.next;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clean() {
        head.next = null;
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linkedList. if the index is invalid, return -1
     */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) curr = curr.next;
        return curr.val;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public boolean addAt(int index, int val) {
        if (index > size) return false;
        if (index < 0) index = 0;

        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) pred = pred.next;
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
        return true;
    }

    public boolean deleteAt(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return false;

        size--;
        // find predecessor of the node to be deleted
        ListNode pred = head;
        for (int i = 0; i < index; ++i) pred = pred.next;
        // delete pred.next
        pred.next = pred.next.next;

        return true;
    }

    public boolean addAtHead(int val) {
        return addAt(0, val);
    }

    public boolean addAtTail(int val) {
        return addAt(size, val);
    }

    /**
     * build the linked list according to the int list
     */
    public void buildAsList(int[] list) {
        // clean the list first
        clean();

        size = list.length;
        ListNode curr = head;
        for (int i = 0; i < size; i++) {
            curr.next = new ListNode(list[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList{");

        ListNode curr = head.next;
        while (curr != null) {
            res.append(curr.val).append(", ");
            curr = curr.next;
        }
        res.append("Length:");
        res.append(size);
        res.append("}");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] list = {3, 2, 0, -4};
        LinkedList linkedList = new LinkedList();
        linkedList.buildAsList(list);
        System.out.println(linkedList);
    }
}
