package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/}
 * 
 */
public class tr_bfs_minimum_depth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        int level = 1;

        while (true) {
            TreeNode c = q.poll();

            if (c == null) {
                level++;
                q.add(null);
            } else if (c.left == null && c.right == null) {
                return level;
            } else {
                if (c.left != null) {
                    q.add(c.left);
                }

                if (c.right != null) {
                    q.add(c.right);
                }
            }
        }
    }
}