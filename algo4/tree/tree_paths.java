import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/binary-tree-paths/}
 *
 */
public class tree_paths
{
    public class TreeNode
    {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root)
    {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();

        path.add(root);
        recurse(root, result, path);
        return result;
    }

    private void recurse(TreeNode c, List<String> result, List<TreeNode> path)
    {
        if (c.left == null && c.right == null) {
            result.add(convertPath(path));
            return;
        }

        if (c.left != null) {
            path.add(c.left);
            recurse(c.left, result, path);
            path.remove(path.size() - 1);
        }

        if (c.right != null) {
            path.add(c.right);
            recurse(c.right, result, path);
            path.remove(path.size() - 1);
        }
    }

    private String convertPath(List<TreeNode> path)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < path.size() - 1; i++) {
            sb.append(path.get(i).val + "->");
        }

        sb.append(path.get(path.size() - 1).val);
        return sb.toString();
    }
}
