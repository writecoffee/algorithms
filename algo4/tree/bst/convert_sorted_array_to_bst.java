package bst;

public class convert_sorted_array_to_bst {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] num) {
        return explore(num, 0, num.length);
    }

    public static TreeNode explore(int[] num, int start, int n) {
        if (n <= 0) {
            return null;
        }

        int mid = start + n / 2;
        TreeNode root = new TreeNode(num[mid]);

        root.left = explore(num, start, mid - start);
        root.right = explore(num, mid + 1, n - (mid - start) - 1);

        return root;
    }
}