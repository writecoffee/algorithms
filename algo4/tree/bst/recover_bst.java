package bst;

import java.util.Stack;

public class recover_bst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode[] t = new TreeNode[2];
        explore(root, t, null);
        swap(t[0], t[1]);
    }

    private TreeNode explore(TreeNode root, TreeNode[] t, TreeNode pre) {
        if (root == null) {
            return pre;
        }

        TreeNode last = explore(root.left, t, pre);
        if (last != null && last.val > root.val) {
            t[1] = root;
            t[0] = t[0] == null ? last : t[0];
        }

        return explore(root.right, t, root);
    }

    private void swap(TreeNode l, TreeNode r) {
        int temp = l.val;
        l.val = r.val;
        r.val = temp;
    }

    /**
     * Firstly, in-order traversal will give us a sorted array of numbers. Now the question becomes
     * to recover a sorted array where two elements were swapped wrongly.
     * 
     * E.g. Given [1, 4, 3, 2, 5], which two shall we swap to fix the array?
     * 
     * One way is starting from the second element in the list and comparing it with its previous
     * one. If it is smaller than its previous one, then we know at least one of the two is in wrong
     * spot. So, the larger one in the first pair and the smaller one in the second pair are the
     * ones we are looking for.
     * 
     * But, how about [1, 3, 2, 4, 5]?
     * 
     * This tells us that if there is only one such pair where the latter one is greater than the
     * previous one. That pair is actually the two element we are looking for.
     * 
     * Since we only need to compare with previous node, we don't need to store all nodes during a
     * traversal. We only need to keep track of the previously visited node. The algorithm is quite
     * similar to the ones in the post of validating BST.
     */
    public void recoverTreeNonrecur(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode[] t = new TreeNode[2];
        TreeNode pre = null, nxt = root;

        while (nxt != null || !s.isEmpty()) {
            if (nxt != null) {
                s.push(nxt);
                nxt = nxt.left;
            } else {
                TreeNode c = s.pop();

                if (pre != null && c.val < pre.val) {
                    if (t[0] == null) {
                        t[0] = pre;
                        t[1] = c;
                    } else {
                        t[1] = c;
                        break;
                    }
                }

                pre = c;
                nxt = c.right;
            }
        }

        swap(t[0], t[1]);
    }
}
