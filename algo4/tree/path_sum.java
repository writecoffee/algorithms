import java.util.ArrayDeque;
import java.util.Deque;

public class path_sum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) ||
               hasPathSum(root.right, sum - root.val);
    }

    public static class MyTreeNode {
        final TreeNode treeNode;
        final int sumSoFar;
        MyTreeNode(TreeNode treeNode, int sumSoFar) {
            this.sumSoFar = sumSoFar;
            this.treeNode = treeNode;
        }
    }

    public static boolean hasPathSumNonrecur(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Deque<MyTreeNode> intermediate = new ArrayDeque<MyTreeNode>();
        Deque<MyTreeNode> innerIntermediate = new ArrayDeque<MyTreeNode>();
        intermediate.addLast(new MyTreeNode(root, 0));
        while (!intermediate.isEmpty()) {
            Deque<MyTreeNode> temp = intermediate;
            intermediate = innerIntermediate;
            innerIntermediate = temp;

            while (!innerIntermediate.isEmpty()) {
                MyTreeNode current = innerIntermediate.pollFirst();

                if (current.treeNode.left == null &&
                    current.treeNode.right == null &&
                    sum - current.sumSoFar - current.treeNode.val == 0) {
                    return true;
                }

                if (current.treeNode.left != null) {
                    intermediate.addLast(new MyTreeNode(current.treeNode.left, current.sumSoFar + current.treeNode.val));
                }

                if (current.treeNode.right != null) {
                    intermediate.addLast(new MyTreeNode(current.treeNode.right, current.sumSoFar + current.treeNode.val));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        hasPathSumNonrecur(new TreeNode(1), 1);
    }
}