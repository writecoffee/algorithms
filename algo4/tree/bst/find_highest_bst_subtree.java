package bst;

public class find_highest_bst_subtree {
    private class TreeNode {
        TreeNode left, right;
        int val;
    }

    private class Result {
        final int depth;
        final boolean isBst; 
        final int lBound;
        final int rBound;

        Result(int _depth, boolean _isBst, int _lBound, int _rBound) {
            depth = _depth;
            isBst = _isBst;
            lBound = _lBound;
            rBound = _rBound;
        }
    }

    private int gMax;

    public int maxBstDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        gMax = 0;
        explore(root);
        return gMax;
    }

    /**
     * If current sub-tree(c) satisfy the BST structure,
     * 
     * LMAX(c) = max(LMAX(c.left), LMAX(c.right)) + 1
     * L(c) = L(c.left)
     * R(c) = R(c.right)
     * 
     * Otherwise
     * 
     * LMAX(c) = Integer.MIN_VALUE
     * 
     */
    private Result explore(TreeNode root) {
        int depth = 0, lBound = root.val, rBound = root.val;

        if (root.left != null) {
            Result lr = explore(root.left);
            if (!lr.isBst) {
                return lr;
            } else if (root.val < lr.rBound) {
                return new Result(-1, false, -1, -1);
            } else {
                lBound = lr.lBound;
                depth = Math.max(depth, lr.depth);
            }
        }

        if (root.right != null) {
            Result rr = explore(root.right);
            if (!rr.isBst) {
                return rr;
            } else if (root.val > rr.lBound) {
                return new Result(-1, false, -1, -1);
            } else {
                rBound = rr.rBound;
                depth = Math.max(depth, rr.depth);
            }
        }

        gMax = Math.max(gMax, depth + 1);
        return new Result(depth + 1, true, lBound, rBound);
    }
}