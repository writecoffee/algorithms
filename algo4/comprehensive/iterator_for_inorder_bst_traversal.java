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
        private final Stack<Integer> s;

        TreeIterator(TreeNode root) {
            if (root == null) {
                throw new IllegalArgumentException();
            }

            s = new Stack<Integer>();

            Stack<TreeNode> ts = new Stack<TreeNode>();
            TreeNode c = root;
            while (c != null || !ts.isEmpty()) {
                if (c != null) {
                    ts.push(c);
                    c = c.right;
                } else {
                    TreeNode i = ts.pop();
                    s.add(i.val);
                    c = i.left;
                }
            }
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }

        public Integer next() {
            if (s.isEmpty()) {
                throw new NoSuchElementException("The tree has been fully explored");
            }

            return s.pop();
        }
    }
}