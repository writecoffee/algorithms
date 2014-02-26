import java.util.ArrayDeque;
import java.util.Deque;

public class same_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> pLevel = new ArrayDeque<TreeNode>();
        Deque<TreeNode> qLevel = new ArrayDeque<TreeNode>();

        if (p == null && q == null) {
            return true;
        } else if (!(p != null && q != null)) {
            return false;
        }

        pLevel.addLast(p);
        qLevel.addLast(q);

        while (!pLevel.isEmpty() && !qLevel.isEmpty()) {
            Deque<TreeNode> pTemp = new ArrayDeque<TreeNode>(pLevel);
            Deque<TreeNode> qTemp = new ArrayDeque<TreeNode>(qLevel);
            pLevel.clear();
            qLevel.clear();

            while (!pTemp.isEmpty() && !qTemp.isEmpty()) {
                TreeNode pCurrent = pTemp.pollFirst();
                TreeNode qCurrent = qTemp.pollFirst();

                if (pCurrent.val != qCurrent.val) {
                    return false;
                }

                if (!(pCurrent.left == null && qCurrent.left == null)
                 && !(pCurrent.left != null && qCurrent.left != null)) {
                    return false;
                }

                if (!(pCurrent.right == null && qCurrent.right == null)
                 && !(pCurrent.right != null && qCurrent.right != null)) {
                    return false;
                }

                if (pCurrent.left != null) {
                    pLevel.addLast(pCurrent.left);
                    qLevel.addLast(qCurrent.left);
                }

                if (qCurrent.right != null) {
                    pLevel.addLast(pCurrent.right);
                    qLevel.addLast(qCurrent.right);
                }
            }
        }

        return pLevel.isEmpty() && qLevel.isEmpty();
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