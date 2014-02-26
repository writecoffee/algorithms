import java.util.ArrayDeque;
import java.util.Deque;

public class recover_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[2];
        inorder(root, nodes, null);
        swap(nodes[0], nodes[1]);
    }

    private static void swap(TreeNode treeNode, TreeNode treeNode2) {
        int temp = treeNode.val;
        treeNode.val = treeNode2.val;
        treeNode2.val = temp;
    }

    private static TreeNode inorder(TreeNode root, TreeNode[] nodes, TreeNode pre) {
        if (root == null) {
            return pre;
        }

        TreeNode last = inorder(root.left, nodes, pre);

        if (last != null && root.val < last.val) {
            nodes[1] = root;

            if (nodes[0] == null) {
                nodes[0] = last;
            } else {
                return root;
            }
        }

        return inorder(root.right, nodes, root);
    }

    public static void recoverTreeNonrecur(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

        while (cur != null) {
            stack.addLast(cur);
            cur = cur.left;
        }

        while (!stack.isEmpty()) {
            cur = stack.pollLast();

            if (pre != null && cur.val < pre.val) {
                if (first == null) {
                    first = pre;
                    second = cur;
                } else {
                    second = cur;
                    break;
                }
            }

            pre = cur;
            cur = cur.right;
            while (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
        }

        swap(first, second);
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r2.left = r4;
        r2.right = r3;
        r3.left = r1;
        r3.right = r5;

        recoverTreeNonrecur(r2);
    }
}