package bst;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA)
 * of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 *
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 *
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another
 * example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of
 * itself according to the LCA definition.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/}
 * [Difficulty] - Easy
 *
 */
public class bst_find_lowest_common_ancestor
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        return find(root, p.val > q.val ? q : p, p.val > q.val ? p : q);
    }

    private TreeNode find(TreeNode cr, TreeNode l, TreeNode r)
    {
        if (cr.val > l.val && cr.val < r.val) {
            return cr;
        } else if (cr == l && cr.val < r.val) {
            return cr;
        } else if (cr == r && cr.val > l.val) {
            return cr;
        } else if (cr.val > l.val && cr.val > r.val) {
            return find(cr.left, l, r);
        } else if (cr.val < l.val && cr.val < r.val) {
            return find(cr.right, l, r);
        } else {
            return null;
        }
    }

    public TreeNode lowestCommonAncestorNonrecur(TreeNode root, TreeNode p, TreeNode q)
    {
        TreeNode cr = root;

        for (TreeNode l = p.val > q.val ? q : p, r = p.val > q.val ? p : q; cr != p && cr != q;) {
            if (cr.val > l.val && cr.val < r.val) {
                return cr;
            } else if (cr.val > l.val && cr.val > r.val) {
                cr = cr.left;
            } else if (cr.val < l.val && cr.val < r.val) {
                cr = cr.right;
            }
        }

        return cr;
    }
}
