import java.util.ArrayList;
import java.util.List;

public class maximum_path_sum_for_general_tree {
    public static class TreeNode {
        public final int val;
        public final List<TreeNode> children;

        TreeNode(int _v) {
            val = _v;
            children = new ArrayList<TreeNode>();
        }
    }

    private int result;

    public int maxTreePathSum(TreeNode root) {
        result = 0;
        explore(root);
        return result;
    }

    public int explore(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int first = 0;
        int second = 0;

        for (TreeNode child : root.children) {
            int pathSum = explore(child);
            if (pathSum > first) {
                second = first;
                first = pathSum;
            } else if (pathSum > second) {
                second = pathSum;
            }
        }

        result = Math.max(result, first + root.val + second);
        return root.val + first;
    }
}