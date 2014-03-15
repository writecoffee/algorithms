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

    public static ArrayList<TreeNode> generateTrees(int n) {
        return generateHelper(n);
    }

    private static ArrayList<TreeNode> generateHelper(int n) {
        return generateHelperRecur(1, n);
    }

    private static ArrayList<TreeNode> generateHelperRecur(int l, int r) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();

        if (l > r) {
            result.add(null);
            return result;
        }

        for (int k = l; k <= r; k++) {
            ArrayList<TreeNode> leftTrees = generateHelperRecur(l, k - 1);
            ArrayList<TreeNode> rightTrees = generateHelperRecur(k + 1, r);

            for (int i = 0; i < leftTrees.size(); i++) {
                for (int j = 0; j < rightTrees.size(); j++) {
                    TreeNode root = new TreeNode(k);
                    root.left = leftTrees.get(i);
                    root.right = rightTrees.get(j);
                    result.add(root);
                }
            }
        }

        return result;
    }

    public static ArrayList<TreeNode> generateTreesDP(int n) {
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

    private static ArrayList<ArrayList<TreeNode>> createTable(int count) {
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        for (int i = 0; i < count; i++) {
            result.add(new ArrayList<TreeNode>());
        }

        return result;
    }

    private static TreeNode copyTree(TreeNode original, int diff) {
        if (null == original) {
            return null;
        }

        TreeNode result = new TreeNode(original.val + diff);
        result.left = copyTree(original.left, diff);
        result.right = copyTree(original.right, diff);

        return result;
    }

    public static void main(String[] args) {
        generateTreesDP(3);
    }
}