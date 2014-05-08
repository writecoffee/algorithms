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

    private int explore(TreeNode root, HashMap<TreeNode, Integer> hMax) {
        if (root == null) {
            return 0;
        }

        int l = explore(root.left, hMax);
        int r = explore(root.right, hMax);

        int lMax;
        if (l < 0 && r < 0) {
            lMax = root.val;
        } else {
            lMax = Math.max(l, r) + root.val;
        }

        int gMax = Integer.MIN_VALUE;

        if (root.left != null) {
            gMax = Math.max(gMax, hMax.get(root.left));
        }

        if (root.right != null) {
            gMax = Math.max(gMax, hMax.get(root.right));
        }

        hMax.put(root, Math.max(Math.max(gMax, lMax), l + r + root.val));
        return lMax;
    }
}