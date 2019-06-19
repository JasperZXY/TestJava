package com.zxy.testCollection;

import java.util.NoSuchElementException;
import java.util.Stack;


/**
 * 用Stack实现 Queue
 *
 * 由于stack是先进后出（FILO），而queue是先进先出的（FIFO）。
 * 也就是说stack进行了一次反向操作把数据压入另一个stack中，这个时候对另一个栈的操作就可以实现FIFO了。
 */
public class Stack2Queue {

    public static void main(String[] args) {
        Queue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        queue.enqueue(6);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        queue.clear();
    }

    public static class MyQueue<T> implements Queue<T> {

        private Stack<T> inStack;
        private Stack<T> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        @Override
        public void enqueue(T t) {
            inStack.push(t);
        }


        @Override
        public T dequeue() {
            if (outStack.isEmpty()) {
                if (inStack.isEmpty()) {
                    throw new NoSuchElementException();
                }
                while (!inStack.isEmpty()) {
                    outStack.add(inStack.pop());
                }
                return outStack.pop();
            }else {
                return outStack.pop();
            }
        }


        @Override
        public void clear() {
            inStack.clear();
            outStack.clear();
        }


        @Override
        public boolean isEmpty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }



    public interface Queue<T> {
        void enqueue(T t);
        T dequeue();
        void clear();
        boolean isEmpty();
    }

}
