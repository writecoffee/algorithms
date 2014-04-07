public class populating_next_right_pointers_in_each_node {

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