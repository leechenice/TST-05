import javax.lang.model.element.Name;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static int i = 0;
    Node buildTree(String str) {
        Node root = null;
        if (str.charAt(i) != '#' ) {
            root = new Node(str.charAt(i));
            i++;
            root.left = buildTree(str);
            root.right = buildTree(str);
        }
        i++;
        return root;

    }

    // 前序遍历   递归来实现
    void preOrderTraversal(Node root){
        if(root == null) { return; }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(Node root){
        if (root == null) { return; }
        inOrderTraversal(root.left);
        System.out.print(root + " ");
        inOrderTraversal(root.right);
    }

    // 后序遍历
    void postOrderTraversal(Node root){
        if (root == null) { return; }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.print(root + " ");
    }

    static int size = 0;
    void getSize1(Node root){
        if (root == null) { return; }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }

    int getSize2(Node root){
        if(root == null) { return 0; }
        return 1 + getSize2(root.left) + getSize2(root.right);

    }

    static int leafSize = 0;
    void getSize3(Node root){
        if(root == null) { return; }
        if (root.left == null && root.right == null) { leafSize++; }
        getSize3(root.left);
        getSize3(root.right);

    }

    int getSize4(Node root) {
        if (root == null) { return 0; }
        if (root.left== null && root.right == null) { return 1; }
        return getSize4(root.right) + getSize4(root.left);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root, int k) {
        if (root == null) { return 0; }
        if (k == 1) { return 1; }
        return getKLevelSize(root,k-1) + getKLevelSize(root,k-1);
    }

    // 获取二叉树的高度
    int getHeight(Node root) {
        if (root == null) { return 0; }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
    // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val) {
        if(root == null) { return null; }
        if(root.val == val) { return root; }
        Node node =  find(root.left,val);
        return node == null ? find(root.right,val) : node;

    }

    public boolean isSubtree(Node s, Node t) {
        if(s == null || t == null) { return false; }
        if (isSameTree(s,t)){ return true; }
        if (isSubtree(s.left,t)) { return true; }
        return isSubtree(s.right, t);

    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {return true;}
        if (p == null || q == null) {return false;}
        if (p.val != q.val) {return false;}
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isBalance(Node root) {
        if (root == null) { return true; }
        return (Math.abs(getHeight(root.left)-getHeight(root.right)) < 2)
                && isSymmetric(root.left) && isSymmetric(root.right);
    }

    public boolean isSymmetric(Node root) {
        if (root == null) { return true; }
        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(Node treeLeft,Node treeRight) {
        if (treeLeft == null && treeRight == null) { return true; }
        if (treeLeft == null || treeRight == null) { return false; }
        return  treeLeft.val == treeRight.val
                && isSymmetricChild(treeLeft.left,treeRight.right)
                && isSymmetricChild(treeLeft.right,treeRight.left);
    }

    public boolean isSymmetric(Node root1,Node root2) {
        if (root1 == null && root2 == null) { return true; }
        if (root1 == null || root2 == null) { return false; }
        return  root1.val == root2.val
                && isSymmetricChild(root1.left,root2.right)
                && isSymmetricChild(root1.right,root2.left);
    }
    // 层序遍历
    void levelOrderTraversal(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
    }
    //分层遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if(root == null) return ret;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new LinkedList<>();
            //1、求当前队列的大小  size
            int size = queue.size();
            //2、while(size > 0)  -->控制当前每一层的数据个数
            while (size > 0) {
                Node cur = queue.poll();
                if (cur != null) {
                    tmp.add(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                size--;
            }
            ret.add(tmp);
        }
        return ret;
    }
    //判断是否完全二叉树
    boolean isCompleteTree(Node root) {
        if (root == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else break;
        }
        while(!queue.isEmpty()) {
            if(queue.poll() != null)
                return false;
        }
        return true;
    }

    // 前序遍历
    void preOrderTraversalNor(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(stack.peek().val + " ");
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        System.out.println();
    }
    // 中序遍历
    void inOrderTraversalNor(Node root){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            System.out.print(stack.peek().val + " ");
            cur = stack.pop().right;
        }
        System.out.println();
    }

    // 后序遍历
    void postOrderTraversalNor(Node root){
       if (root == null) return;
       Stack<Node> stack = new Stack<>();
       Node cur = root;
       Node prev = cur;
       while (cur != null || !stack.empty()) {
           while (cur != null) {
               stack.push(cur);
               cur = cur.left;
           }
           cur = stack.peek();
           if (cur.right == null || cur.right == prev) {
               System.out.println(stack.pop().val);
               prev = cur;
               cur = null;
           }else {
               cur = cur.right;
           }
       }
    }

    //最近公共祖先
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q) return root;
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }


}
