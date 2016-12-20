package algorithms.btree;

/**
 * 二叉树.
 *
 * @author fu tao
 * @since 2016/12/20 15:04
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {

    }
}
