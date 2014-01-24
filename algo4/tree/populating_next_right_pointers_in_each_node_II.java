public class populating_next_right_pointers_in_each_node_II {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    private static void connectLevel(TreeLinkNode current) {
        while (current != null) {
            if (current.left != null && current.right != null) {
                current.left.next = current.right;
            }

            TreeLinkNode next = current.next;
            while (next != null && next.left == null && next.right == null) {
                next = next.next;
            }

            if (next == null) {
                break;
            }

            TreeLinkNode nextChild = (next.left != null) ? next.left : next.right;
            if (current.right != null) {
                current.right.next = nextChild;
            } else if (current.left != null) {
                current.left.next = nextChild;
            }

            current = next;
        }
    }

    public static void connect(TreeLinkNode root) {
        TreeLinkNode first = root;

        while (first != null) {
            connectLevel(first);

            while (first != null && first.left == null && first.right == null) {
                first = first.next;
            }

            if (first != null) {
                first = (first.left != null) ? first.left : first.right;
            }
        }
    }
}