import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class validate_same_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTreeBfs(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (!(a != null && b != null)) {
            return false;
        }

        Queue<TreeNode> qa = new LinkedList<TreeNode>();
        Queue<TreeNode> qb = new LinkedList<TreeNode>();

        qa.add(a);
        qb.add(b);

        while (!qa.isEmpty() && !qb.isEmpty()) {
            Queue<TreeNode> pa = new LinkedList<TreeNode>(qa);
            Queue<TreeNode> pb = new LinkedList<TreeNode>(qb);
            qa.clear();
            qb.clear();

            while (!pa.isEmpty() && !pb.isEmpty()) {
                TreeNode ca = pa.poll();
                TreeNode cb = pb.poll();

                if (ca.val != cb.val) {
                    return false;
                }

                if (ca.left != null && cb.left != null) {
                    qa.add(ca.left);
                    qb.add(cb.left);
                } else if (!(ca.left == null && cb.left == null)) {
                    return false;
                }

                if (ca.right != null && cb.right != null) {
                    qa.add(ca.right);
                    qb.add(cb.right);
                } else if (!(ca.right == null && cb.right == null)) {
                    return false;
                }
            }
        }

        return qa.isEmpty() && qb.isEmpty();
    }

    public static boolean isSameTreeDfs(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (!(a != null && b != null)) {
            return false;
        }

        Stack<TreeNode> sa = new Stack<TreeNode>();
        Stack<TreeNode> sb = new Stack<TreeNode>();
        sa.push(a);
        sb.push(b);

        while (!sa.isEmpty() && !sb.isEmpty()) {
            TreeNode ca = sa.pop();
            TreeNode cb = sb.pop();

            if (ca.val != cb.val) {
                return false;
            }

            if (ca.left != null && cb.left != null) {
                sa.push(ca.left);
                sb.push(cb.left);
            } else if (!(ca.left == null && cb.left == null)) {
                return false;
            }

            if (ca.right != null && cb.right != null) {
                sa.push(ca.right);
                sb.push(cb.right);
            } else if (!(ca.right == null && cb.right == null)) {
                return false;
            }
        }

        return sa.isEmpty() && sb.isEmpty();
    }

    public static boolean isSameTreeRecur(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (!(p != null && q != null)) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }

        return isSameTreeRecur(p.left, q.left) && isSameTreeRecur(p.right, q.right);
    }
}