public class flatten_binary_tree_to_linked_list {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    void flatten(TreeNode root) {
        flattenHelper(root);
    }

    TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode rightTree = root.right;
        TreeNode last = root;

        if (root.left != null) {
            last = flattenHelper(root.left);
            root.right = root.left;
            root.left = null;
        }

        if (rightTree != null) {
            last.right = rightTree;
            last = flattenHelper(root.right);
        }

        return last;
    }

}