/**
 * DoubleLinkedList.java
 * Author: Ten phun
 * This class implement double linked list
 * Methods:
 */
package leetcode.datastructure;

public class DoubleLinkedList {
    private int size;
    private final ListNode head, tail; // sentinel nodes
    public DoubleLinkedList(){
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int getSize() {
        return size;
    }

    public ListNode getHead() {
        if(isEmpty())return null;
        else return head.next;
    }

    public ListNode getTail() {
        if(isEmpty()) return null;
        return tail.prev;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void clean(){
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index){
        // if index is invalid
        if(index<0||index>=size)return -1;

        // choose which way is faster
        ListNode curr = head;
        if (index + 1 < size - index)
            for(int i = 0; i < index + 1; ++i) curr = curr.next;
        else {
            curr = tail;
            for(int i = 0; i < size - index; ++i) curr = curr.prev;
        }

        return curr.val;
    }


    public boolean addAtHead(int val) {
        ListNode tmp = head.next;

        size++;
        ListNode toAdd = new ListNode(val);
        head.next = toAdd;
        toAdd.prev = head;
        toAdd.next = tmp;
        tmp.prev = toAdd;
        return true;
    }

    public boolean addAtTail(int val) {
        ListNode tmp = tail.prev;

        size++;
        ListNode toAdd = new ListNode(val);
        tail.prev = toAdd;
        toAdd.next = tail;
        toAdd.prev = tmp;
        tmp.next = toAdd;
        return true;
    }

    public boolean addAt(int index, int val){
        if (index > size) return false;
        if (index < 0) index = 0;

        // find predecessor and successor of the node to be added
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; i++) pred = pred.next;
            succ = pred.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index; i++) succ = succ.prev;
            pred = succ.prev;
        }

        // insertion itself
        size++;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;

        return true;
    }

    public void deleteAt(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        // find predecessor and successor of the node to be deleted
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; i++) pred = pred.next;
            succ = pred.next.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) succ = succ.prev;
            pred = succ.prev.prev;
        }

        // delete pred.next
        size--;
        pred.next = succ;
        succ.prev = pred;
    }

    public void buildAsList(int[] list){
        clean();

        size = list.length;
        ListNode curr = head;
        for (int i = 0; i < size; i++) {
            curr.next = new ListNode(list[i]);
            curr = curr.next;
        }
        curr.next = tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("DoubleLinkedList{");

        ListNode curr = head.next;
        while (curr != tail) {
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
        DoubleLinkedList dll = new DoubleLinkedList();
        System.out.println(dll);
        dll.addAtHead(2);
        System.out.println(dll.getHead());
        System.out.println(dll.getTail());
        dll.addAt(0,3);
        dll.addAtTail(4);
        System.out.println(dll);
        dll.deleteAt(2);
        System.out.println(dll);
        dll.buildAsList(list);
        System.out.println(dll);
    }

}
