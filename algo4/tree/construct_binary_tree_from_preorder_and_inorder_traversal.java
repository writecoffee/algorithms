public class construct_binary_tree_from_preorder_and_inorder_traversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, 0, preorder.length);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preorderIndex, int inorderIndex, int n) {
        if (n <= 0) {
            return null;
        }

        int rootVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInInorder = -1;
        for (int i = inorderIndex; i < inorderIndex + n; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }

        assert rootIndexInInorder != -1;

        root.left = buildTreeHelper(
                        preorder,
                        inorder,
                        preorderIndex + 1,
                        inorderIndex,
                        rootIndexInInorder - inorderIndex);

        root.right = buildTreeHelper(
                        preorder,
                        inorder,
                        preorderIndex + 1 + (rootIndexInInorder - inorderIndex),
                        rootIndexInInorder + 1,
                        n - 1 - (rootIndexInInorder - inorderIndex));

        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[] { 1, 2 }, new int[] { 2, 1 });
    }
}