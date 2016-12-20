package algorithmsTest;

import algorithms.btree.BTreeLevelOrderTraversal;
import algorithms.btree.TreeNode;
import org.junit.Test;

import java.util.List;

/**
 * BTreeLevelOrderTraversal测试类.
 *
 * @author fu tao
 * @since 2016/12/20 14:58
 */
public class BTreeLevelOrderTraversalTest {

    @Test
    public void levelOrder(){
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(5);
        root.setLeft(left1);
        root.setRight(right1);
        BTreeLevelOrderTraversal bTreeLevelOrderTraversal = new BTreeLevelOrderTraversal();
        List<List<Integer>> lists = bTreeLevelOrderTraversal.levelOrder(root);
    }
}
