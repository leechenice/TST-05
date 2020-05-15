public class MyLinkedList {
    Node head;
    public MyLinkedList(Node head) { this.head = head; }

    public boolean palindrome(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (head != slow) {
            if (slow.val != head.val) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public Node removeDuplicateNodes(Node head) {
        Node newNode = new Node(-1);
        Node tmp = newNode;
        Node cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            }else {
                tmp.next = cur;
                tmp = tmp.next;
            }
            cur = cur.next;
        }
        return newNode.next;

    }
}
