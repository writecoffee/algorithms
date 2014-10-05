/**
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/count-complete-tree-nodes/}
 * [Tag]        - $tree$
 *
 */
public class bs_count_nodes_for_complete_binary_tree
{
    public static class TreeNode
    {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public int countNodeNonRecursive(TreeNode root)
    {
        int currentId = 1, height = getHeight(root);

        if (height <= 1) {
            return height;
        }

        for (TreeNode c = root; c != null;) {
            int rHeight = getHeight(c.right);

            if (2 == height) {
                return rHeight > 0 ? ((currentId << 1) + 1) : (currentId << 1);
            }

            if (rHeight == height - 1) {
                currentId = (currentId << 1) + 1;
                c = c.right;
            } else if (rHeight == height - 2) {
                currentId = (currentId << 1);
                c = c.left;
            }

            height--;
        }

        return currentId;
    }

    private int getHeight(TreeNode root)
    {
        int height = 0;

        while (null != root) {
            root = root.left;
            height++;
        }

        return height;
    }

    public int countNodes(TreeNode root) {
        int height = getHeight(root);

        if (height <= 1) {
            return height;
        }

        return explore(root, height, 1);
    }

    private int explore(TreeNode root, int height, int id) {
        int rHeight = getHeight(root.right);

        if (height == 2) {
            return rHeight > 0 ? ((id << 1) + 1) : (id << 1);
        }

        if (rHeight == height - 1) {
            return explore(root.right, height - 1, (id << 1) + 1);
        } else {
            return explore(root.left, height - 1, (id << 1));
        }
    }
}
