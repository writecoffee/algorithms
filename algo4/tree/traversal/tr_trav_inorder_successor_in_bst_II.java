package traversal;

import java.util.Stack;

/**
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/inorder-successor-in-bst/}
 *
 */
public class tr_trav_inorder_successor_in_bst_II
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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
    {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode c = root;

        while (c != null || !stk.isEmpty()) {
            if (c == null) {
                TreeNode nxt = stk.pop();

                if (nxt == p) {
                    c = nxt;
                    break;
                }

                c = nxt.right;

            } else {
                stk.push(c);
                c = c.left;
            }
        }

        if (c == null) {
            return null;
        }

        if (c.right != null) {
            TreeNode t = c.right;
            while (t.left != null) {
                t = t.left;
            }

            return t;
        } else if (stk.isEmpty()) {
            return null;
        } else {
            return stk.pop();
        }
    }
}
