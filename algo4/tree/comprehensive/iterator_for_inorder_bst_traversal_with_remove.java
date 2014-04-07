package comprehensive;

import java.util.IdentityHashMap;
import java.util.NoSuchElementException;
import java.util.Stack;

public class iterator_for_inorder_bst_traversal_with_remove {
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
        private final IdentityHashMap<TreeNode, TreeNode> hParent;
        private TreeNode current;
        private TreeNode root;

        TreeIterator(TreeNode _root) {
            if (_root == null) {
                throw new IllegalArgumentException();
            }

            root = _root;
            hParent = new IdentityHashMap<TreeNode, TreeNode>();
            s = new Stack<TreeNode>();
            hParent.put(root, null);
            exploreLeftSubTree(root);
        }

        private void exploreLeftSubTree(TreeNode root) {
            TreeNode c = root;
            while (c != null) {
                s.push(c);
                hParent.put(c.left, c);
                c = c.left;
            }
        }

        public boolean hasNext() {
            return !s.isEmpty();
        }

        public Integer next() {
            if (s.isEmpty()) {
                throw new NoSuchElementException("The tree has been fully explored");
            }

            current = s.pop();
            if (current.right != null) {
                hParent.put(current.right, current);
                exploreLeftSubTree(current.right);
            }

            return current.val;
        }

        public void remove() {
            if (current == null) {
                throw new IllegalStateException("Current pointer is null");
            }

            TreeNode parent = getParent(current);
            TreeNode sub = deleteNode(current);

            if (parent != null) {
                if (parent.left == current) {
                    parent.left = sub;
                } else {
                    parent.right = sub;
                }
            } else {
                root = sub;
            }

            current = null;
        }

        private TreeNode getParent(TreeNode c) {
            return hParent.get(c);
        }

        private TreeNode deleteNode(TreeNode target) {
            if (target.left == null && target.right == null) {
                return null;
            } else if (target.right == null) {
                return target.left;
            } else if (target.right.left == null) {
                target.right.left = target.left;
                return target.right;
            } else {
                TreeNode pre = target.right;
                TreeNode i = target.right.left;
                while (i.left != null) {
                    pre = i;
                    i = i.left;
                }

                TreeNode sub = deleteNode(i);
                pre.left = sub;
                i.left = target.left;
                i.right = target.right;

                return i;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node4.left = node3;
        node4.right = node7;
        node7.left = node5;
        node5.right = node6;
        node7.right = node8;

        TreeIterator iter = new TreeIterator(node4);
        while (iter.hasNext()) {
            if (iter.next() == 6) {
                iter.remove();
            }
        }

        TreeIterator iterAfterward = new TreeIterator(iter.root);
        while (iterAfterward.hasNext()) {
            System.out.println(iterAfterward.next());
        }
    }
}