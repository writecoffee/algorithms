package comprehensive;

public class threading_same_level_nodes_on_perfect_binary_tree {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode c = root;
        while (c.left != null) {
            TreeLinkNode i = c;
            while (i.next != null) {
                i.left.next = i.right;
                i.right.next = i.next.left;
                i = i.next;
            }
            i.left.next = i.right;

            c = c.left;
        }
    }
}