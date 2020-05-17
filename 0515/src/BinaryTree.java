class TNode {
    char val;
    TNode left;
    TNode right;
    public TNode(char val) {
        this.val = val;
    }

}
public class BinaryTree {
    public TNode buildTree() {
        TNode A = new TNode('A');
        TNode B = new TNode('B');
        TNode C = new TNode('C');
        TNode D = new TNode('D');
        TNode E = new TNode('E');
        TNode F = new TNode('F');
        TNode G = new TNode('G');
        TNode H = new TNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
    // 前序遍历   递归来实现
    void preOrderTraversal(TNode root){
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(TNode root){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root + " ");
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(TNode root){
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.print(root + " ");
    }
    static int size = 0;
    void getSize1(TNode root){
        if (root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    int getSize2(TNode root){
        if(root == null) {
            return 0;
        }
        return 1 + getSize2(root.left) + getSize2(root.right);

    }
    static int leafSize = 0;

    void getSize3(TNode root){
        if(root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getSize3(root.left);
        getSize3(root.right);

    }
    int getSize4(TNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left== null && root.right == null) {
            return 1;
        }
        return getSize4(root.right) + getSize4(root.left);
    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(TNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root,k-1) + getKLevelSize(root,k-1);
    }
    // 获取二叉树的高度
    int getHeight(TNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

     // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
   // 一旦找到，立即返回，不需要继续在其他位置查找
    TNode find(TNode root, int val) {
        if(root == null) { return null; }
        if(root.val == val) { return root; }
        TNode node =  find(root.left,val);
        return node == null ? find(root.right,val) : node;

    }
    public boolean isSubtree(TNode s, TNode t) {
        if(s == null || t == null) { return false; }
        if (isSameTree(s,t)){ return true; }
        if (isSubtree(s.left,t)) { return true; }
        return isSubtree(s.right, t);

    }

    public boolean isSameTree(TNode p, TNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isBalance(TNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left)-getHeight(root.right)) < 2
                && isSymmetric(root.left) && isSymmetric(root.right);
    }
    public boolean isSymmetric(TNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }
    public boolean isSymmetricChild(TNode treeLeft,TNode treeRight) {
        if (treeLeft == null && treeRight == null) {
            return true;
        }
        if (treeLeft == null || treeRight == null) {
            return false;
        }
        return treeLeft.val == treeRight.val
                && isSymmetricChild(treeLeft.left,treeRight.right)
                && isSymmetricChild(treeLeft.right,treeRight.left);
    }

}



