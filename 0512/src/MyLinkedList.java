class MyLinkedList {
    Node head;
    /** Initialize your data structure here. */
    public MyLinkedList(Node head) {
        this.head = head;
    }
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (this.head == null)
            return -1;
        if (index == 0)
            return this.head.val;
        if (index > size())
            return -1;
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        if (this.head != null) {
            cur.next = this.head;
            this.head.prev = cur;
        }
        this.head = cur;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = new Node(val);
        if (this.head == null) {
            this.head = cur;
        }else {
            Node tmp = this.head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = cur;
            cur.prev = tmp;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size()) {
            addAtTail(val);
            return;
        }
        if (index > size()) {
            return;
        }
        Node cur = this.head;
        Node tmp = new Node(val);
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        tmp.prev = cur;
        tmp.next = cur.next;
        cur.next.prev = tmp;
        cur.next = tmp;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index > size() - 1) {
            return;
        }
        if (this.head == null) {
            return;
        }
        if (index == 0) {
            this.head = this.head.next;
            this.head.prev = null;
        }
        Node cur = this.head;
        for (int i = 0; i < index -1; i++) {
            cur = cur.next;
        }
        Node tmp = cur.next;
        cur.next = tmp.next;
        tmp.next.prev = cur;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */