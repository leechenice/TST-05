import java.util.Arrays;

public class TextHeap {
    int[] elem;
    int usedSize;
    private TextHeap() {
        this.elem = new int[10];
    }
    public void heapSort() {
        int end = this.usedSize - 1;
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end--);
        }
    }
    public void pop() {
        if (isEmpty()) return;
        this.elem[0] = this.elem[this.usedSize-1];
        adjustDown(0,--this.usedSize);
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }
    public void push(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem,elem.length+elem.length/2);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }
    public boolean isFull() {
        return usedSize == elem.length;
    }
    public void adjustUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }
    public void adjustDown(int root, int len) {
        int child = 2 * root + 1;
        while (child < len) {
            if (child+1 < len && elem[child] < elem[child+1]) {
                child++;
            }
            if (elem[child] > elem[root]) {
                int tmp = elem[child];
                elem[child] = elem[root];
                elem[root] = tmp;
                child = 2 * child + 1;
            }else {
                break;
            }
        }

    }
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            usedSize++;
        }
        for (int i = (usedSize-1-1) / 2; i >= 0 ; i--) {
            adjustDown(i,usedSize);
        }
    }
}
