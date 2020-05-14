package com.demo;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    public Queue<Integer> queue;


    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.queue.offer(x);

    }
        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (this.queue.size() > 1) {
                this.queue.offer(this.queue.remove());
            }
            return this.queue.remove();
        }

            /** Get the top element. */
            public int top() {
                int top = pop();
                this.queue.offer(top);
                return top;
            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return this.queue.isEmpty();

            }
        }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
