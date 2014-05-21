package gmax;

import java.util.HashMap;

public class maximum_path_sum_for_binary_tree {
    public class TreeNode {
        public final int val;
        public final TreeNode left;
        public final TreeNode right;

        TreeNode(int _v, TreeNode _left, TreeNode _right) {
            val = _v;
            left = _left;
            right = _right;
        }
    }

    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Integer> hMax = new HashMap<TreeNode, Integer>();
        explore(root, hMax);
        return hMax.get(root);
    }

    /**
     * LMAX(c) = max(c, c + LMAX(c.left), c + LMAX(c.right))
     * GMAX(c) = max(GMAX(c.left), GMAX(c.right), LMAX(c), c + LMAX(c.left) + LMAX(c.right))
     * 
     */
    private int explore(TreeNode root, HashMap<TreeNode, Integer> hMax) {
        if (root == null) {
            return 0;
        }

        int ll = explore(root.left, hMax);
        int lr = explore(root.right, hMax);

        int lMax = Math.max(root.val, Math.max(ll, lr) + root.val);

        int gl = Integer.MIN_VALUE;
        int gr = Integer.MIN_VALUE;

        if (root.left != null) {
            gl = hMax.get(root.left);
        }

        if (root.right != null) {
            gr = hMax.get(root.right);
        }

        hMax.put(root, Math.max(Math.max(Math.max(gl, gr), lMax), ll + lr + root.val));
        return lMax;
    }
}