import java.util.HashMap;
import java.util.Stack;

public class count_nodes_for_complete_binary_tree {
    public static class TreeNodeUtil {
        static boolean isNullNode(TreeNode n) {
            return n == null;
        }

        static TreeNode getLeftChildNode(TreeNode n) {
            return n.left;
        }

        static TreeNode getRightChildNode(TreeNode n) {
            return n.right;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (TreeNodeUtil.isNullNode(root)) {
            return 0;
        }
        return countHelper(root, 0, 0, getHeight(root)) + 1;
    }

    public int countHelper(TreeNode root, int id, int level, int h) {
        TreeNode l = TreeNodeUtil.getLeftChildNode(root);
        TreeNode r = TreeNodeUtil.getRightChildNode(root);

        if (TreeNodeUtil.isNullNode(l) && TreeNodeUtil.isNullNode(r)) {
            if (level == h - 1) {
                return id;
            } else {
                return -1;
            }
        }

        int result;
        if (!TreeNodeUtil.isNullNode(r)) {
            result = countHelper(r, id * 2 + 2, level + 1, h);
            if (result > 0) {
                return result;
            }
        }

        return countHelper(l, id * 2 + 1, level + 1, h);
    }

    public int getHeight(TreeNode root) {
        int height = 0;
        while (!TreeNodeUtil.isNullNode(root)) {
            root = TreeNodeUtil.getLeftChildNode(root);
            height++;
        }
        return height;
    }

    public int countNodesNonrecur(TreeNode root) {
        if (TreeNodeUtil.isNullNode(root)) {
            return 0;
        }

        int h = getHeight(root);
        Stack<TreeNode> s = new Stack<TreeNode>();
        HashMap<TreeNode, Integer> levelMap = new HashMap<TreeNode, Integer>();
        HashMap<TreeNode, Integer> idMap = new HashMap<TreeNode, Integer>();
        s.push(root);
        levelMap.put(root, 0);
        idMap.put(root, 0);

        while (!s.isEmpty()) {
            TreeNode c = s.pop();
            int level = levelMap.get(c);
            int id = idMap.get(c);
            TreeNode l = TreeNodeUtil.getLeftChildNode(root);
            TreeNode r = TreeNodeUtil.getRightChildNode(root);

            if (TreeNodeUtil.isNullNode(l) && TreeNodeUtil.isNullNode(r)) {
                if (level == h - 1) {
                    return id;
                }
            } else {
                s.push(l);
                idMap.put(l, id * 2 + 1);
                levelMap.put(l, level + 1);

                if (!TreeNodeUtil.isNullNode(r)) {
                    s.push(r);
                    idMap.put(r, id * 2 + 2);
                    levelMap.put(r, level + 1);
                }
            }
        }

        return -1;
    }
}