/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 *
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/serialize-and-deserialize-binary-tree/}
 * [Difficulty] - Medium
 *
 */
public class tr_serialize_and_deserialize_binary_tree
{
    public static class TreeNode
    {
        int      val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
        }
    }

    public String serialize(TreeNode root)
    {
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        String result = sb.toString().substring(1);

        System.out.println(result);
        return result;
    }

    void preOrder(TreeNode root, StringBuilder sb)
    {
        if (root == null) {
            sb.append(",null");
            return;
        }

        sb.append(",").append(root.val);
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (data == null) {
            return null;
        }

        int[] mutableInteger = { 0 };
        String[] arr = data.split(",");
        TreeNode root = helper(arr, mutableInteger);
        return root;
    }

    public TreeNode helper(String[] arr, int[] mutableInteger)
    {
        TreeNode root = new TreeNode(Integer.parseInt(arr[mutableInteger[0]]));

        mutableInteger[0]++;
        if (arr[mutableInteger[0]].equals("null")) {
            root.left = null;
        } else {
            root.left = helper(arr, mutableInteger);
        }

        mutableInteger[0]++;
        if (arr[mutableInteger[0]].equals("null")) {
            root.right = null;
        } else {
            root.right = helper(arr, mutableInteger);
        }

        return root;
    }
}
