package comprehensive;

public class threading_same_level_nodes_on_binary_tree {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    /**
     * Only use constant extra space on any binary tree.
     *          1
     *        /    \
     *       2      4
     *        \    / \
     *         5  2   7
     *             \ 
     *              3
     */
    void connect(TreeLinkNode root) {
        TreeLinkNode i = root;

        while (i != null) {
            TreeLinkNode j = i;
            TreeLinkNode p = null;
            i = null;

            while (j != null) {
                TreeLinkNode l = j.left, r = j.right;

                if (l != null || r != null) {
                    if (l != null) {
                        l.next = r;
                    }

                    if (p != null) {
                        p.next = l == null ? r : l;
                    }

                    p = r != null ? r : l;
                    i = i == null ? (l == null ? r : l) : i;
                }

                j = j.next;
            }
        }
    }
}