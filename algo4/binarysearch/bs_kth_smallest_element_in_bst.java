import java.util.IdentityHashMap;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 *
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 *
 * Hint:
 *
 * 1. Try to utilize the property of a BST.
 *
 * 2. What if you could modify the BST node's structure?
 *
 * 3. The optimal runtime complexity is O(height of BST).
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/kth-smallest-element-in-a-bst/}
 *
 */
public class bs_kth_smallest_element_in_bst
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

    private static IdentityHashMap<TreeNode, Integer> subTreeSize = new IdentityHashMap<>();
    static {
        subTreeSize.put(null, 0);
    }

    private boolean preprocessed = false;

    public int kthSmallest(TreeNode root, int k)
    {
        if (!preprocessed) {
            preprocess(root);
            preprocessed = !preprocessed;
        }

        while (root != null) {
            int leftSub = subTreeSize.get(root.left);

            if (leftSub == k - 1) {
                return root.val;
            } else if (leftSub + 1 < k) {
                root = root.right;
                k = k - leftSub - 1;
            } else {
                root = root.left;
            }
        }

        return -1;
    }

    private int preprocess(TreeNode root)
    {
        if (root == null) {
            return 0 ;
        }

        int left = preprocess(root.left),
            right = preprocess(root.right);

        int result = left + right + 1;
        subTreeSize.put(root, result);

        return result;
    }
}
