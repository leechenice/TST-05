class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
        this.data = data;
    }

}
public class MyQueue<T> {
    int usedSize;
    Node<T> front;
    Node<T> tail;
    public boolean offer(T val) {
        Node<T> cur = new Node<>(val);
        if (isEmpty()) {
            this.front = cur;
        }else {
            this.tail.next = cur;
        }
        this.tail = cur;
        this.usedSize++;
        return true;
    }
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        T data = this.front.data;
        this.front = this.front.next;
        usedSize--;
        return data;
    }
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.front.data;
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }
    public int size() {
        return this.usedSize;
    }

}


