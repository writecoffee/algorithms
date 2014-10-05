package traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both
 * v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 *
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
 *
 * Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/}
 *
 */
public class tr_trav_lowest_common_ancestor_of_binary_tree
{
    public class TreeNode
    {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2)
    {
        Map<TreeNode, Integer> hLevel = new HashMap<>();
        Map<TreeNode, TreeNode> hParent = new HashMap<>();

        Queue<TreeNode> p = new LinkedList<>();
        p.add(root);
        hLevel.put(root, 0);
        hParent.put(root, null);
        int level = 1;

        while (!p.isEmpty()) {
            Queue<TreeNode> q = new LinkedList<>(p);
            p.clear();

            while (!q.isEmpty()) {
                TreeNode c = q.poll();
                hLevel.put(c, level);

                if (c.left != null) {
                    hParent.put(c.left, c);
                    p.add(c.left);
                }

                if (c.right != null) {
                    hParent.put(c.right, c);
                    p.add(c.right);
                }
            }

            level++;
        }

        int level1 = hLevel.get(node1), level2 = hLevel.get(node2);

        TreeNode c = level1 > level2 ? node1 : node2;
        for (int i = 0; i < Math.max(level1, level2) - Math.min(level1, level2); ++i) {
            c = hParent.get(c);
        }

        if (level1 > level2) {
            node1 = c;
        } else {
            node2 = c;
        }

        while (node1 != node2) {
            node1 = hParent.get(node1);
            node2 = hParent.get(node2);
        }

        return node1;
    }
}
