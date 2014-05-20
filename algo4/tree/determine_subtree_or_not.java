import java.util.ArrayList;
import java.util.Stack;

public class determine_subtree_or_not {
    public class TreeNode {
        public final int v;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int _v) {
            v = _v;
        }
    }

    /**
     * The worst case time is O(k * n) where k is the number of occurrence of b in tree a.
     * 
     */
    public boolean isSubtree(TreeNode a, TreeNode b) {
        for (TreeNode start : findAllStartPoint(a, b)) {
            if (determine(start, b)) {
                return true;
            }
        }

        return false;
    }

    private boolean determine(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (!(a != null && b != null)) {
            return false;
        } else if (a.v != b.v) {
            return false;
        }

        return determine(a.left, b.left) && determine(a.right, b.right);
    }

    private ArrayList<TreeNode> findAllStartPoint(TreeNode a, TreeNode b) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        TreeNode c = a;
        Stack<TreeNode> s = new Stack<TreeNode>();

        while (c != null || !s.isEmpty()) {
            if (c != null) {
                s.push(c);
                c = c.left;
            } else {
                TreeNode nxt = s.pop();

                if (nxt.v == b.v) {
                    result.add(nxt);
                }

                c = nxt.right;
            }
        }

        return result;
    }
}