package traversal;

public class construct_binary_tree_from_inorder_and_postorder_traversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, 0, inorder.length);
    }

    public static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inorderIndex, int postorderIndex, int n) {
        if (n <= 0) {
            return null;
        }

        int inorderRootIndex = 0;
        for (int i = inorderIndex; i < inorderIndex + n; i++) {
            if (inorder[i] == postorder[postorderIndex + n - 1]) {
                inorderRootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(postorder[postorderIndex + n - 1]);

        root.left = buildTreeHelper(
                        inorder,
                        postorder,
                        inorderIndex,
                        postorderIndex,
                        inorderRootIndex - inorderIndex);

        root.right = buildTreeHelper(
                        inorder,
                        postorder,
                        inorderRootIndex + 1,
                        postorderIndex + inorderRootIndex - inorderIndex,
                        n - 1 - (inorderRootIndex - inorderIndex));

        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[] { 2, 1, 3 }, new int[] { 2, 3, 1 });
    }
}