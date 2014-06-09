package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a root node of a tree, each node in the tree contains a value, calculate the
 * maximum non-negative sum of any possible path starting from any node and terminating
 * at any node in the tree.
 * 
 * For example: 
 * 
 *       -10
 *      /  |  \
 *     2   3   4
 *        / \
 *       5  -1
 *          /
 *         6
 *        /
 *       -1
 *       
 * The result should be 13, route from node(5) to node(6).
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.itint5.com/oj/#13}
 *
 */
public class tr_recur_maximum_path_sum_for_general_tree_I {
    public class TreeNode {
        public final int val;
        public final List<TreeNode> children;

        TreeNode(int _v) {
            val = _v;
            children = new ArrayList<TreeNode>();
        }
    }

    private int gMax;

    public int maxTreePathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        gMax = 0;
        explore(root);
        return gMax;
    }

    private int explore(TreeNode r) {
        int cp1 = 0, cp2 = 0;

        for (TreeNode c : r.children) {
            int cp = explore(c);
            int t = Math.min(cp1, cp);
            cp1 = Math.max(cp1, cp);
            cp2 = Math.max(cp2, t);
        }
 
        int lMax = r.val + Math.max(cp1, cp2);
        gMax = Math.max(gMax, r.val + cp1 + cp2);
        return lMax;
    }
}