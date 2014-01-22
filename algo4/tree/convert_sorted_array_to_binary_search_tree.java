public class convert_sorted_array_to_binary_search_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBSTHelper(num, 0, num.length);
    }

    public static TreeNode sortedArrayToBSTHelper(int[] num, int start, int n) {
        if (n <= 0) {
            return null;
        }

        int mid = start + n / 2;
        TreeNode root = new TreeNode(num[mid]);

        root.left = sortedArrayToBSTHelper(num, start, mid - start);
        root.right = sortedArrayToBSTHelper(num, mid + 1, n - (mid - start) - 1);

        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[] { -1, 0, 1, 2 });
    }
}