import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class path_sum_II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        probe(root, sum, result, path);
        return result;
    }

    public void probe(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ArrayList<Integer> newResult = new ArrayList<Integer>(path);
                result.add(newResult);
            }

            path.remove(path.size() - 1);
            return;
        }

        probe(root.left, sum - root.val, result, path);
        probe(root.right, sum - root.val, result, path);

        path.remove(path.size() - 1);
    }

    public static class MyTreeNode {
        final TreeNode treeNode;
        final ArrayList<Integer> pathSoFar;
        final int sumSoFar;
        MyTreeNode(TreeNode treeNode, ArrayList<Integer> pathSoFar, int sumSoFar) {
            this.pathSoFar = pathSoFar;
            this.treeNode = treeNode;
            this.sumSoFar = sumSoFar;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSumNonrecur(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Deque<MyTreeNode> intermediate = new ArrayDeque<MyTreeNode>();
        Deque<MyTreeNode> innerIntermediate = new ArrayDeque<MyTreeNode>();
        intermediate.addLast(new MyTreeNode(root, new ArrayList<Integer>(), 0));
        while (!intermediate.isEmpty()) {
            Deque<MyTreeNode> temp = intermediate;
            intermediate = innerIntermediate;
            innerIntermediate = temp;

            while (!innerIntermediate.isEmpty()) {
                MyTreeNode current = innerIntermediate.pollFirst();
                if (current.treeNode.left == null &&
                    current.treeNode.right == null &&
                    sum - current.sumSoFar - current.treeNode.val == 0) {
                    ArrayList<Integer> newPath = new ArrayList<Integer>(current.pathSoFar);
                    newPath.add(current.treeNode.val);
                    result.add(newPath);
                    continue;
                }

                if (current.treeNode.left != null) {
                    ArrayList<Integer> newPath = new ArrayList<Integer>(current.pathSoFar);
                    newPath.add(current.treeNode.val);
                    intermediate.addLast(new MyTreeNode(current.treeNode.left, newPath, current.sumSoFar + current.treeNode.val));
                }

                if (current.treeNode.right != null) {
                    ArrayList<Integer> newPath = new ArrayList<Integer>(current.pathSoFar);
                    newPath.add(current.treeNode.val);
                    intermediate.addLast(new MyTreeNode(current.treeNode.right, newPath, current.sumSoFar + current.treeNode.val));
                }
            }
        }

        return result;
    }
}