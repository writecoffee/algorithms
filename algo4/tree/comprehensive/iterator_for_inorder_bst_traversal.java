package comprehensive;

import java.util.NoSuchElementException;
import java.util.Stack;

public class iterator_for_inorder_bst_traversal {
    static class TreeNode {
        public final int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int _value) {
            val = _value;
        }
    }

    static class TreeIterator {
        private final Stack<TreeNode> s;
        private TreeNode current;

        TreeIterator(TreeNode root) {
            if (root == null) {
                throw new IllegalArgumentException();
            }

            s = new Stack<TreeNode>();
            exploreLeftSubTree(root);
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }

        private void exploreLeftSubTree(TreeNode root) {
            TreeNode c = root;
            while (c != null) {
                s.push(c);
                c = c.left;
            }
        }

        public Integer next() {
            if (s.isEmpty()) {
                throw new NoSuchElementException("The tree has been fully explored");
            }

            current = s.pop();
            if (current.right != null) {
                exploreLeftSubTree(current.right);
            }

            return current.val;
        }
    }
}