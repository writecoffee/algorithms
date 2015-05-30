package segmenttree;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * Note:
 *
 * 1. The array is only modifiable by the update function.
 * 2. You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/range-sum-query-mutable/}
 * [Difficulty] - Hard
 *
 */
public class tr_segment_range_sum_query_mutable
{
    public class OptimizedTemplate
    {
        /**
         * Binary Indexed Trees (BIT or Fenwick tree):
         * https://www.topcoder.com/community/data-science/data-science-
         * tutorials/binary-indexed-trees/
         *
         * Example:
         *
         * given an array a[0]...a[7], we use a array BIT[9] to represent a
         * tree, where index [2] is the parent of [1] and [3], [6] is the parent
         * of [5] and [7], [4] is the parent of [2] and [6], and [8] is the
         * parent of [4].
         *
         * i.e.,
         *
         * BIT[] as a binary tree:
         *
         *            ______________*
         *            ______*
         *            __*     __*
         *            *   *   *   *
         * indices: 0 1 2 3 4 5 6 7 8
         *
         * BIT[i] = ([i] is a left child) ? the partial sum from its left most
         * descendant to itself: the partial sum from its parent (exclusive) to
         * itself. (check the range of "__").
         *
         * e.g.
         *
         * BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
         *
         * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
         *
         * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
         *
         * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
         *
         * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
         * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
         * last 1-bit from [i].
         *
         * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
         * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
         * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
         *
         * To obtain the original value of a[7] (corresponding to index [8] of
         * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
         * starting from [idx-1], for current [i], the next subtrahend [j] is
         * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
         * way but using extra space is to store the original array.)
         */
        public class NumArray
        {
            private int[] nums;
            private int[] BIT;
            private int   n;

            public NumArray(int[] nums)
            {
                this.nums = nums;

                n = nums.length;
                BIT = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    init(i, nums[i]);
                }
            }

            private void init(int i, int val)
            {
                i++;
                while (i <= n) {
                    BIT[i] += val;
                    i += (i & -i);
                }
            }

            public void update(int i, int val)
            {
                int diff = val - nums[i];
                nums[i] = val;
                init(i, diff);
            }

            private int getSum(int i)
            {
                int sum = 0;
                i++;

                while (i > 0) {
                    sum += BIT[i];
                    i -= (i & -i);
                }

                return sum;
            }

            public int sumRange(int i, int j)
            {
                return getSum(j) - getSum(i - 1);
            }
        }
    }

    public class SimpleTemplate
    {
        public class NumArray
        {
            public class TreeNode
            {
                int left;
                int right;
                int sum;
                TreeNode leftChild;
                TreeNode rightChild;

                TreeNode(int l, int r) {
                    left = l;
                    right = r;
                }
            }

            private TreeNode root;

            public NumArray(int[] nums) {
                int n = nums.length;

                if (n == 0) {
                    return;
                }

                root = constructTree(nums, 0, n);
            }

            private TreeNode constructTree(int[] nums, int start, int end)
            {
                int l = start;
                int r = end - 1;

                TreeNode c = new TreeNode(l, r);

                if (l == r) {
                    c.sum = nums[l];
                    return c;
                }

                int mid = (l + r) / 2;

                c.leftChild = constructTree(nums, start, mid + 1);
                c.rightChild = constructTree(nums, mid + 1, end);
                c.sum = c.leftChild.sum + c.rightChild.sum;

                return c;
            }

            void update(int i, int val)
            {
                i = Math.max(i, root.left);
                i = Math.min(i, root.right);

                updateRecurse(root, i, val);
            }

            private int updateRecurse(TreeNode c, int i, int val)
            {
                if (c.left == c.right && c.left == i) {
                    int diff = val - c.sum;
                    c.sum = val;
                    return diff;
                }

                int mid = (c.left + c.right) / 2;

                if (i <= mid) {
                    int diff = updateRecurse(c.leftChild, i, val);
                    c.sum += diff;
                    return diff;
                } else {
                    int diff = updateRecurse(c.rightChild, i, val);
                    c.sum += diff;
                    return diff;
                }
            }

            public int sumRange(int i, int j)
            {
                return sumRangeRecurse(i, j, root);
            }

            private int sumRangeRecurse(int i, int j, TreeNode c)
            {
                if (c.left >= i && c.right <= j) {
                    return c.sum;
                }

                TreeNode lNode = c.leftChild;
                TreeNode rNode = c.rightChild;

                int lSum = 0;
                if (i <= lNode.right) {
                    lSum = sumRangeRecurse(i, Math.min(lNode.right, j), lNode);
                }

                int rSum = 0;
                if (j >= rNode.left) {
                    rSum = sumRangeRecurse(Math.max(rNode.left, i), j, rNode);
                }

                return lSum + rSum;
            }
        }
    }
}
