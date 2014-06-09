package recursion;

import java.util.ArrayList;
import java.util.HashMap;
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
 * The additional requirement here is that we cannot use global variable.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.itint5.com/oj/#13}
 *
 */
public class tr_recur_maximum_path_sum_for_general_tree_II {
    public class TreeNode {
        public final int val;
        public final List<TreeNode> children;

        TreeNode(int _v) {
            val = _v;
            children = new ArrayList<TreeNode>();
        }
    }

    public int maxTreePathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        HashMap<TreeNode, Integer> h = new HashMap<TreeNode, Integer>();
        h.put(null, 0);
        explore(root, h);
        return h.get(root);
    }

    private int explore(TreeNode r, HashMap<TreeNode, Integer> h) {
        int cp1 = 0, cp2 = 0, cgmax = 0;

        for (TreeNode c : r.children) {
            int cp = explore(c, h);
            int t = Math.min(cp1, cp);
            cp1 = Math.max(cp1, cp);
            cp2 = Math.max(cp2, t);
            cgmax = Math.max(cgmax, h.get(c));
        }
 
        int lMax = r.val + Math.max(cp1, cp2);
        h.put(r, Math.max(r.val + cp1 + cp2, cgmax));
        return lMax;
    }
}