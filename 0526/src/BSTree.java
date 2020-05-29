public class BSTree {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    public boolean insert(int val) {
        Node node = new Node(val);
        if(root == null) {
            root = node;
            return true;
        }

        Node cur = root;
        Node parent = null;

        while (cur != null) {
            if (cur.val == val) {
                return false;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        //cur为空  位置找到  进行插入
        //两种情况-》
        if (parent.val < val) {
            parent.right = node;
        }else {
            parent.left = node;
        }
        return true;

    }
    public boolean remove(int key) {
        Node cur = this.root;
        Node parent = null;
        while(cur != null) {
            if (cur.val == key) {
                removeNode(parent,cur);
                return true;
            }else if (key > cur.val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }
    public void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }else if (cur == parent.left) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node goalParent = cur;
            Node goal = cur.left;
            while (goal.right != null) {
                goalParent = goal;
                goal = goal.right;
            }
            cur.val = goal.val;
            if (goalParent.right == goal) {
                goalParent.right = goal.left;
            }else {
                goalParent.left = goal.left;
            }
        }
    }
}

