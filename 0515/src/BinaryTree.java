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
}



