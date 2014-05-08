import java.util.Stack;

public class flatten_binary_tree_to_singly_linked_list {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode psudoHead = new TreeNode(-1);
        TreeNode pre = psudoHead;
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode c = s.pop();

            pre.left = null;
            pre.right = c;
            pre = c;

            if (c.right != null) {
                s.push(c.right);
            }

            if (c.left != null) {
                s.push(c.left);
            }
        }
    }
}
