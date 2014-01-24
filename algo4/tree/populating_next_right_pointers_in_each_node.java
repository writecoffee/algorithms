public class populating_next_right_pointers_in_each_node {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {
        TreeLinkNode first = root;

        while (first != null) {
            TreeLinkNode current = first;

            while (current != null) {
                if (current.left != null) {
                    current.left.next = current.right;
                }

                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }

            first = first.left;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(2);
        TreeLinkNode left = new TreeLinkNode(1);
        TreeLinkNode right = new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        connect(root);
    }
}