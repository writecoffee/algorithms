package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * to
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/invert-binary-tree/}
 *
 */
public class tr_bfs_invert_binary_tree
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

    public TreeNode invertTree(TreeNode root)
    {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            Queue<TreeNode> p = new LinkedList<TreeNode>(q);
            q.clear();

            while (!p.isEmpty()) {
                TreeNode c = p.poll();
                invert(c);

                if (c.left != null) {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }
            }
        }

        return root;
    }

    public TreeNode invertTreeWithSingleQueue(TreeNode root)
    {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            while (q.peek() != null) {
                TreeNode c = q.poll();
                invert(c);

                if (c.left != null) {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }
            }

            q.poll();
            if (!q.isEmpty()) {
                q.add(null);
            }
        }

        return root;
    }

    public TreeNode invertTreeRecur(TreeNode root)
    {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        return root;
    }

    private void invert(TreeNode c)
    {
        TreeNode t = c.left;
        c.left = c.right;
        c.right = t;
    }
}
