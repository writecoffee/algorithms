import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Queue;

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

    public void probe(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result,
                    ArrayList<Integer> path) {
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

    private class BtInfo {
        private final int cSum;
        private final TreeNode parent;

        private BtInfo(int _cSum, TreeNode _parent) {
            cSum = _cSum;
            parent = _parent;
        }
    }

    public ArrayList<ArrayList<Integer>> pathSumOptimized(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        IdentityHashMap<TreeNode, BtInfo> h = new IdentityHashMap<TreeNode, BtInfo>();
        q.add(root);
        h.put(root, new BtInfo(root.val, null));

        while (!q.isEmpty()) {
            Queue<TreeNode> p = new LinkedList<TreeNode>(q);
            q.clear();

            while (!p.isEmpty()) {
                TreeNode c = p.poll();
                TreeNode l = c.left;
                TreeNode r = c.right;
                int cSum = h.get(c).cSum;

                if (l == null && r == null && cSum == sum) {
                    result.add(backtrack(c, h));
                }

                if (l != null) {
                    q.add(l);
                    h.put(l, new BtInfo(cSum + l.val, c));
                }

                if (r != null) {
                    q.add(r);
                    h.put(r, new BtInfo(cSum + r.val, c));
                }
            }
        }

        return result;
    }

    private ArrayList<Integer> backtrack(TreeNode c, IdentityHashMap<TreeNode, BtInfo> h) {
        ArrayDeque<Integer> r = new ArrayDeque<Integer>();

        while (c != null) {
            r.addFirst(c.val);
            c = h.get(c).parent;
        }

        return new ArrayList<Integer>(r);
    }
}