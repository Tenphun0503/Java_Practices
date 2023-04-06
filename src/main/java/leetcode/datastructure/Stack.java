/**
 * @See <a href=""></a>
 */
package leetcode.datastructure;

import java.util.NoSuchElementException;

public class Stack<K> {
    private K[] stack;
    private int top;

    public Stack(int size) {
        stack = (K[]) new Object[size];
        top = -1;
    }

    public void push(K item) {
        if (top == stack.length - 1) {
            throw new StackOverflowError();
        }
        top++;
        stack[top] = item;
    }

    public K pop(){
        K res;
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return stack[top--];
    }

    public K peek(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return stack[top];
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
            sb.append(stack[i].toString()).append('\t');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
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
