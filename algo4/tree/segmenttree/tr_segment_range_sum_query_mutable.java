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
            public class SegmentTreeNode
            {
                public int start, end, sum;
                public SegmentTreeNode left, right;

                public SegmentTreeNode(int start, int end, int sum)
                {
                    this.start = start;
                    this.end = end;
                    this.sum = sum;
                }
            }

            private SegmentTreeNode root;

            void update(int i, int val)
            {
                updateTree(i, val, root);
            }

            public NumArray(int[] nums)
            {
                root = buildTreeNode(nums, 0, nums.length - 1);
            }

            public int sumRange(int i, int j)
            {
                return treeSum(i, j, root);
            }

            private int treeSum(int start, int end, SegmentTreeNode root)
            {
                if (root == null || start > root.end || end < root.start) {
                    return 0;
                }

                if (start == root.start && end == root.end) {
                    return root.sum;
                }

                int leftSum = 0;
                int rightSum = 0;

                if (root.left != null) {
                   leftSum = treeSum(Math.max(root.left.start, start),
                                     Math.min(root.left.end, end),
                                     root.left);
                }

                if (root.right != null) {
                   rightSum = treeSum(Math.max(root.right.start, start),
                                      Math.min(root.right.end, end),
                                      root.right);
                }

                return leftSum + rightSum;
            }

            private SegmentTreeNode buildTreeNode(int[] nums, int start, int end)
            {
                if (start > end) {
                    return null;
                }

                if (start == end) {
                    return new SegmentTreeNode(start, end, nums[start]);
                }

                SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
                int mid = start + (end - start) / 2;
                root.left = buildTreeNode(nums, start, mid);
                root.right = buildTreeNode(nums, mid + 1, end);

                if (root.left != null) {
                    root.sum += root.left.sum;
                }

                if (root.right != null) {
                    root.sum += root.right.sum;
                }

                return root;
            }

            private void updateTree(int index, int val, SegmentTreeNode root)
            {
                if (root.start > index || root.end < index) {
                    return;
                }

                int start = root.start;
                int end = root.end;
                int mid = start + (end - start) / 2;

                if (start == end) {
                    root.sum = val;
                    return;
                }

                if (index > mid) {
                    updateTree(index, val, root.right);
                } else {
                    updateTree(index, val, root.left);
                }

                if (root.left != null) {
                    root.sum += root.left.sum;
                }

                if (root.right != null) {
                    root.sum += root.right.sum;
                }
            }
        }
    }
}
