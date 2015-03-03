package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 *
 * Given the following binary tree,
 *
 *     1            <---
 *   /   \
 *  2     3         <---
 *   \     \
 *    5     4       <---
 *
 * You should return [1, 3, 4].
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/binary-tree-right-side-view/}
 *
 */
public class tr_bfs_right_side_view
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

    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            while (true) {
                TreeNode c = q.poll();

                if (c.left != null) {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }

                if (q.peek() == null) {
                    result.add(c.val);
                    break;
                }
            }

            q.poll();
            if (!q.isEmpty()) {
                q.add(null);
            }
        }

        return result;
    }
}
