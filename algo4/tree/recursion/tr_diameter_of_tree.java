package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a root node of a tree, find the longest path that can start from any node in
 * the tree and terminate at any node in the tree (be more specific, terminate at any
 * leave in the tree).
 * 
 * For example: 
 * 
 *         *
 *      /  |  \
 *     *   *   *
 *        / \
 *       *   *
 *          /
 *         *
 *        /
 *       *
 * 
 * The result should be 6.
 * 
 * [Difficulty] - Medium
 * [Source]     - A variation of {@linkplain http://www.itint5.com/oj/#13}
 *
 */
public class tr_diameter_of_tree {
    public class TreeNode {
        public final int val;
        public final List<TreeNode> children;

        TreeNode(int _v) {
            val = _v;
            children = new ArrayList<TreeNode>();
        }
    }

    private int gMax;

    public int getDiameter(TreeNode root) {
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

        int lMax = 1 + Math.max(cp1, cp2);
        gMax = Math.max(gMax, 1 + cp1 + cp2);
        return lMax;
    }
}