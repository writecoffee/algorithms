import java.util.ArrayDeque;
import java.util.Deque;

public class sum_root_to_leaf_numbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class MyTreeNode {
        public final TreeNode treeNode;
        public final int sum;

        MyTreeNode(int sum, final TreeNode treeNode) {
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        Deque<MyTreeNode> q = new ArrayDeque<MyTreeNode>();
        q.addLast(new MyTreeNode(0, root));

        while (!q.isEmpty()) {
            MyTreeNode myNode = q.pollLast();
            int sum = myNode.sum * 10 + myNode.treeNode.val;
            TreeNode currNode = myNode.treeNode;

            if (currNode.left == null && currNode.right == null) {
                result += sum;
                continue;
            }

            if (currNode.left != null) {
                q.addLast(new MyTreeNode(sum, currNode.left));
            }

            if (currNode.right != null) {
                q.addLast(new MyTreeNode(sum, currNode.right));
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}