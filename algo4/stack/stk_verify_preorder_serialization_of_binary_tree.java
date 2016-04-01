import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null
 * node, we record the node's value. If it is a null node, we record using a sentinel value such
 * as #.
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 *
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
 * where # represents a null node.
 *
 * Given a string of comma separated values, verify whether it is a correct preorder traversal
 * serialization of a binary tree. Find an algorithm without reconstructing the tree.
 *
 * Each comma separated value in the string must be either an integer or a character '#'
 * representing null pointer.
 *
 * You may assume that the input format is always valid, for example it could never contain two
 * consecutive commas such as "1,,3".
 *
 * Example 1:
 *
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 *
 * Example 2:
 * "1,#"
 * Return false
 *
 * Example 3:
 * "9,#,#,1"
 * Return false
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/}
 * [Difficulty] - Medium
 *
 */
public class stk_verify_preorder_serialization_of_binary_tree
{
    /**
     * With indegree solution.
     */
    public boolean isValidSerialization(String preorder)
    {
        String[] strs = preorder.split(",");
        int inDegree = 1;

        for (String s : strs) {
            inDegree--;

            if (inDegree < 0) {
                return false;
            }

            if (!"#".equals(s)) {
                inDegree += 2;
            }
        }

        return inDegree == 0;
    }

    public boolean isValidSerializationStack(String preorder)
    {
        String[] splitted = preorder.split(",");
        int n = splitted.length;
        Stack<String> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            String c = splitted[i];

            while ("#".equals(c) && stk.size() >= 2 && "#".equals(stk.peek())) {
                stk.pop();

                if (stk.peek().equals("#")) {
                    break;
                }

                stk.pop();
            }

            stk.push(c);
        }

        return stk.isEmpty() || (stk.size() == 1 && "#".equals(stk.peek()));
    }
}
