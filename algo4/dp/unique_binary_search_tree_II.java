import java.util.ArrayList;

public class unique_binary_search_tree_II {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return explore(1, n);
    }

    private ArrayList<TreeNode> explore(int l, int r) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();

        if (l > r) {
            result.add(null);
            return result;
        }

        for (int k = l; k <= r; k++) {
            ArrayList<TreeNode> lr = explore(l, k - 1);
            ArrayList<TreeNode> rr = explore(k + 1, r);

            for (int i = 0; i < lr.size(); i++) {
                for (int j = 0; j < rr.size(); j++) {
                    TreeNode root = new TreeNode(k);
                    root.left = lr.get(i);
                    root.right = rr.get(j);
                    result.add(root);
                }
            }
        }

        return result;
    }

    public ArrayList<TreeNode> generateTreesDP(int n) {
        ArrayList<ArrayList<TreeNode>> dp = createTable(n + 1);
        dp.get(0).add(null);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ArrayList<TreeNode> leftTrees = dp.get(j - 1);
                ArrayList<TreeNode> rightTrees = dp.get(i - j);

                for (int mi = 0; mi < leftTrees.size(); mi++) {
                    for (int nj = 0; nj < rightTrees.size(); ++nj) {
                        TreeNode root = new TreeNode(j);
                        root.left = copyTree(leftTrees.get(mi), 0);
                        root.right = copyTree(rightTrees.get(nj), j);
                        dp.get(i).add(root);
                    }
                }
            }
        }

        return dp.get(n);
    }

    private ArrayList<ArrayList<TreeNode>> createTable(int count) {
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        for (int i = 0; i < count; i++) {
            result.add(new ArrayList<TreeNode>());
        }

        return result;
    }

    private TreeNode copyTree(TreeNode original, int diff) {
        if (null == original) {
            return null;
        }

        TreeNode result = new TreeNode(original.val + diff);
        result.left = copyTree(original.left, diff);
        result.right = copyTree(original.right, diff);

        return result;
    }
}