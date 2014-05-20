import java.util.HashMap;

/**
 * Problem: How to select i-th order statistic from augmented search tree 
 * (with subtree sizes)?
 * 
 * Start at root x, with children y and z, let a = size(y)
 * 
 * (1) if a == i - 1 return x's key
 * (2) if a >= i recursively compute i-th order statistic of search tree rooted at y
 * (3) if a < i - 1 recursively compute (i - a - 1)-th order statistic of search tree
 *     rooted at z.
 *     
 * Running time = Theta(height).
 *
 */
public class find_kth_statistic_in_augmented_binary_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode find(TreeNode root, int k, HashMap<TreeNode, Integer> hSize) {
        if (k <= 0 || k > hSize.get(root)) {
            return null;
        }

        return explore(root, hSize, k);
    }

    private TreeNode explore(TreeNode root, HashMap<TreeNode, Integer> hSize, int k) {
        int l = root.left == null ? 0 : hSize.get(root.left);

        if (l == k - 1) {
            return root;
        } else if (l > k - 1) {
            return explore(root.left, hSize, k);
        } else {
            return explore(root.right, hSize, k - l - 1);
        }
    }
}