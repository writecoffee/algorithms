import java.util.HashMap;
import java.util.Stack;

public class sum_root_to_leaf_numbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *     1
     *    / \
     *   2   3
     *   
     * The root-to-leaf path 1->2 represents the number 12.
     * The root-to-leaf path 1->3 represents the number 13.
     * 
     * Return the sum = 12 + 13 = 25.
     */ 
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        HashMap<TreeNode, TreeNode> h = new HashMap<TreeNode, TreeNode>();
        h.put(root, null);
        while (!s.isEmpty()) {
            TreeNode c = s.pop();

            if (c.left == null && c.right == null) {
                result += backtrack(c, h);
                continue;
            }

            if (c.right != null) {
                s.push(c.right);
                h.put(c.right, c);
            }

            if (c.left != null) {
                s.push(c.left);
                h.put(c.left, c);
            }
        }

        return result;
    }

    private int backtrack(TreeNode c, HashMap<TreeNode, TreeNode> h) {
        int t = 0;
        int i = 1;
        while (c != null) {
            t += i * c.val;
            i *= 10;
            c = h.get(c);
        }

        return t;
    }
}