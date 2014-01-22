public class convert_sorted_list_to_binary_search_tree {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private ListNode headSoFar = null;

    public TreeNode sortedListToBST(ListNode head) {
        headSoFar = head;
        return sortedListToBSTHelper(0, getLength(head));
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    public TreeNode sortedListToBSTHelper(int start, int n) {
        assert n >= 0;

        if (n == 0) {
            return null;
        }

        int mid = start + n / 2;

        TreeNode left = sortedListToBSTHelper(start, mid - start);
        TreeNode root = new TreeNode(headSoFar.val);
        headSoFar = headSoFar.next;
        TreeNode right = sortedListToBSTHelper(mid + 1, n - (mid - start) - 1);

        root.left = left;
        root.right = right;

        return root;
    }
}