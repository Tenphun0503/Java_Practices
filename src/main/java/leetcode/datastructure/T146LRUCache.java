/**
 * 146. LRU Cache
 * @see <a href="https://leetcode.com/problems/lru-cache/"></a>
 */
package leetcode.datastructure;

import java.util.HashMap;
import java.util.StringJoiner;

public class T146LRUCache {
    class Node{
        int value;
        int key;
        Node prev;
        Node next;

        Node(){}

        Node(int val){
            this.value = val;
        }
        Node(int key, int val){
            this.key = key;
            this.value = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", key=" + key +
                    '}';
        }
    }

    private Node head = new Node();
    private Node tail = new Node();

    public void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void moveToHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

        addNode(node);
    }
    public Node popTail(){
        Node pop = tail.prev;
        pop.prev.next = tail;
        tail.prev=pop.prev;
        return pop;
    }
    public void printNodes(){
        Node tmp = head.next;
        StringJoiner sj = new StringJoiner("->","(",")");
        while (tmp!=tail){
            sj.add(tmp.key+"="+tmp.value);
            tmp = tmp.next;
        }
        System.out.println(sj);
    }

    private int capacity;

    private HashMap<Integer, Node> map = new HashMap<>();

    public T146LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get (int key){
        System.out.println("get " + key );
        Node node = map.get(key);
        if (node==null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        Node node = map.get(key);
        if(node==null){
            Node newNode = new Node(key, value);
            addNode(newNode);
            map.put(key, newNode);
            if(map.size()>capacity){
                map.remove(popTail().key);
            }

        }else{
            node.value = value;
            moveToHead(node);
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        T146LRUCache cache = new T146LRUCache(2);
        cache.put(1,1);
        cache.printNodes();
        cache.put(2,2);
        cache.printNodes();
        System.out.println(cache.get(1));
        cache.printNodes();
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
