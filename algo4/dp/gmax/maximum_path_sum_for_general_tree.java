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

    private int gMax;

    public int maxTreePathSum(TreeNode root) {
        gMax = 0;
        explore(root);
        return gMax;
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
        
        int lMax;
        if (first < 0 && second < 0) {
            lMax = root.val;
        } else {
            lMax = first + root.val;
        }

        gMax = Math.max(Math.max(gMax, lMax), first + root.val + second);
        return lMax;
    }
}