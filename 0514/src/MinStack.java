import java.util.Stack;

class MinStack {
    public Stack<Integer> s2;
    public Stack<Integer> s1;


    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.empty() || s2.peek() >= x) {
            s2.push(x);
        }

    }

    public void pop() {
        if (!s1.empty() && s1.pop().equals(s2.peek())) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */