import java.util.Stack;

class StockSpanner {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StockSpanner() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!stack1.empty() && stack1.peek() <= price) {
            stack1.pop();
            w += stack2.pop();
        }
        stack1.push(price);
        stack2.push(w);
        return w;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */