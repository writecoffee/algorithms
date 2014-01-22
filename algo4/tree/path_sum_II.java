import java.util.ArrayList;

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
}