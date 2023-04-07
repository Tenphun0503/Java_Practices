/**
 * @See <a href=""></a>
 */
package leetcode.datastructure;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<K> {
    private ArrayList<K> stack;
    private int top;

    public Stack() {
        stack = new ArrayList<>();
        top = -1;
    }

    public void push(K item) {
        top++;
        stack.add(item);
    }

    public K pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(top--);
    }

    public K peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(top);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top+1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            sb.append(stack.get(i).toString()).append('\t');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
    }


}
