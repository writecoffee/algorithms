import java.util.Stack;

/**
 * Given an integer array with no duplicates. A max tree building on this array
 * is defined as follow:
 *
 * The root is the maximum number in the array The left subtree and right
 * subtree are the max trees of the subarray divided by the root number.
 * Construct the max tree by the given array.
 *
 * Have you met this question in a real interview? Yes Example Given [2, 5, 6,
 * 0, 3, 1], the max tree constructed by this array is:
 *
 *     6
 *    / \
 *   5   3
 *  /   / \
 * 2   0   1
 *
 * Challenge O(n) time and memory.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/max-tree/}
 * [Difficulty] - Hard
 *
 */
public class stk_max_tree
{
    public class TreeNode
    {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode maxTree(int[] data)
    {
        int n = data.length;
        Stack<TreeNode> stk = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int cval;
            if (i == n) {
                cval = Integer.MAX_VALUE;
            } else {
                cval = data[i];
            }

            TreeNode c = new TreeNode(cval);

            while (!stk.isEmpty()) {
                TreeNode smallest = stk.peek();

                if (smallest.val > cval) {
                    break;
                }

                stk.pop();
                if (stk.isEmpty() || stk.peek().val > cval) {
                    c.left = smallest;
                } else {
                    stk.peek().right = smallest;
                }
            }

            stk.push(c);
        }

        return stk.peek().left;
    }
}
