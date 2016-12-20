package algorithms.btree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 按层次遍历二叉树.
 * 每层节点放入到队列中，遍历节点值后，再把每个节点的叶子节点依次放入到新的队列中，类推，依次取出所有深度的节点.
 * @author fu tao
 * @since 2016/12/19 17:38
 */
public class BTreeLevelOrderTraversal {


    List<Integer> levelList;
    List<List<Integer>> allList = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        return nextLevel(queue);
    }

    public List<List<Integer>> nextLevel(Queue<TreeNode> queue) {
        if (queue == null) {
            return null;
        }
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        levelList = new ArrayList<Integer>();
        TreeNode node;
        while (true) {
            node = queue.poll();
            if (node == null) {
                break;
            }
            levelList.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        allList.add(levelList);
        if (nextLevel.size() == 0) {
            return allList;
        } else {
            return nextLevel(nextLevel);
        }
    }
}
