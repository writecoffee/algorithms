package comprehensive;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/binary-search-tree-iterator/}
 * [Tag]        - $tree$, $traversal$, $stack$
 *
 */
public class iterator_for_inorder_bst_traversal
{
    public class TreeNode
    {
        public final int val;
        TreeNode         left;
        TreeNode         right;

        TreeNode(int _value)
        {
            val = _value;
        }
    }

    Stack<TreeNode> s = new Stack<TreeNode>();
    TreeNode        c = null;

    class BSTIterator
    {
        public BSTIterator(TreeNode root)
        {
            if (root == null) {
                return;
            }

            s = new Stack<TreeNode>();
            exploreLeftSubTree(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext()
        {
            return !s.isEmpty();
        }

        /** @return the next smallest number */
        public int next()
        {
            c = s.pop();
            if (c.right != null) {
                exploreLeftSubTree(c.right);
            }

            return c.val;
        }

        private void exploreLeftSubTree(TreeNode root)
        {
            TreeNode c = root;
            while (c != null) {
                s.push(c);
                c = c.left;
            }
        }
    }
}
