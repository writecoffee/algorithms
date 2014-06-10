package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/}
 * 
 */
public class tr_bfs_maximum_depth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        int level = 1;

        while (true) {
            TreeNode c = q.poll();

            if (c == null && q.isEmpty()) {
                break;
            } else if (c == null) {
                level++;
                q.add(null);
            } else if (c.left == null && c.right == null) {
                continue;
            } else if (c.left == null) {
                q.add(c.right);
            } else if (c.right == null) {
                q.add(c.left);
            } else {
                q.add(c.left);
                q.add(c.right);
            }
        }

        return level;
    }
}