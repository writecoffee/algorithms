import java.util.ArrayList;

/**
 * You are given a binary tree in which each node contains a value. Design an algorithm to print all
 * paths which sum to a given value. The path does not need to start or end at the root or a leaf.
 * 
 * What is the time complexity of this algorithm (assuming a balanced binary tree)? Well, if a node
 * is at level r, we do r amount of work (that's in the looking "up" step). We can take a guess at
 * 0(n log(n)) since there are n nodes doing an average of log(n) amount of work on each step.
 * 
 * {@linkplain CC150-4.9}
 * 
 */
public class path_sum_III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum, int depth) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        explore(root, path, sum, result);
        return result;
    }

    private void explore(TreeNode root, ArrayList<Integer> path, int sum, ArrayList<ArrayList<Integer>> result) {
        int tsum = 0;
        for (int i = path.size() - 1; i >= 0; --i) {
            tsum += path.get(i);
            if (tsum == sum) {
                result.add(convert(path, i, path.size() - 1));
            }
        }

        if (root.left != null) {
            path.add(root.left.val);
            explore(root.left, path, sum, result);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            explore(root.right, path, sum, result);
            path.remove(path.size() - 1);
        }
    }

    private ArrayList<Integer> convert(ArrayList<Integer> path, int start, int end) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = start; i <= end; ++i) {
            result.add(path.get(i));
        }

        return result;
    }
}