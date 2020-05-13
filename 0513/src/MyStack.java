import java.util.Arrays;

public class MyStack<T> {
    public T[] elem;
    public int top;
    public MyStack() {
        this.elem = (T[]) new Object[10];
    }
    private void kr() {
        this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
    }
    public boolean isFull() {
        return this.top == this.elem.length;
    }

    public void push(T val) {
        if (isFull()) {
           kr();
        }
        this.elem[this.top++] = val;
    }
    public boolean empty() {
        return this.top == 0;
    }
    public T pop() {
        if (empty()) {
            throw new RuntimeException("栈空");
        }
        return this.elem[--this.top];
    }
    public T peek() {
        if (empty()) {
            throw new RuntimeException("栈空");
        }
        return this.elem[this.top - 1];
    }
    public int size() {
        return this.top;
    }
}
