public class least_common_ancestor {
    public static class TreeNode {
        public final int v;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int _v, TreeNode _left, TreeNode _right) {
            v = _v;
            left = _left;
            right = _right;
        }
    }

    public static class TreeNodeWithParent {
        public final int v;
        public TreeNodeWithParent parent;

        TreeNodeWithParent(int _v) {
            v = _v;
        }
    }

    /**
     * Contract: p and q must exist in the tree.
     */
    TreeNode commonAncestorWithAssurance(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p && root == q) {
            return root;
        }

        TreeNode x = commonAncestorWithAssurance(root.left, p, q);
        if (x != null && x != p && x != q) {
            return x;
        }

        TreeNode y = commonAncestorWithAssurance(root.right, p, q);
        if (y != null && y != p && y != q) {
            return y;
        }

        if (x != null && y != null) {
            return root;
        } else if (root == p || root == q) {
            return root;
        } else {
            return x == null ? y : x;
        }
    }

    public static class Result {
        public final TreeNode node;
        public final boolean isAncestor;

        public Result(TreeNode _node, boolean _isAncestor) {
            node = _node;
            isAncestor = _isAncestor;
        }
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q) {
            return p;
        }

        return commonAncestorRevised(root, p, q).node;
    }

    Result commonAncestorRevised(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }

        if (root == p && root == q) {
            return new Result(root, true);
        }

        Result x = commonAncestorRevised(root.left, p, q);
        if (x.isAncestor) {
            return x;
        }

        Result y = commonAncestorRevised(root.right, p, q);
        if (y.isAncestor) {
            return y;
        }

        if (x.node != null && y.node != null) {
            return new Result(root, true);
        } else if (root == p || root == q) {
            return new Result(root, x.node != null || y.node != null);
        } else {
            return new Result(x.node != null ? x.node : y.node, false);
        }
    }

    /**
     * Another version of the LCA problem. Each node has a parent pointer and the two input
     * are guaranteed to exist in the tree.
     * 
     */
    public TreeNodeWithParent getLCA(TreeNodeWithParent node1, TreeNodeWithParent node2) {
        int l1 = getLevel(node1);
        int l2 = getLevel(node2);

        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; ++i) {
                node1 = node1.parent;
            }
        } else if (l2 > l1) {
            for (int i = 0; i < l2 - l1; ++i) {
                node2 = node2.parent;
            }
        }

        while (node1 != node2) {
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return node1;
    }

    public int getLevel(TreeNodeWithParent node) {
        int h = 0;
        while (node.parent != null) {
            node = node.parent;
            h++;
        }
        return h;
    }
}