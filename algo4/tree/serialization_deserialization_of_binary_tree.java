public class serialization_deserialization_of_binary_tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static String serialize(TreeNode root) {
        return writeHelper(root).toString();
    }

    public static StringBuilder writeHelper(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if (root != null) {
            sb.append(root.val + " ");
        } else {
            return sb.append("# ");
        }

        sb.append(writeHelper(root.left));
        sb.append(writeHelper(root.right));
        return sb;
    }

    private static int start = 0;

    public static TreeNode deserialize(String input) {
        return constructHelper(input);
    }

    public static TreeNode constructHelper(String s) {
        if (s.charAt(start) == '#') {
            start += 2;
            return null;
        }

        int valEnd = s.indexOf(' ', start);
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(start, valEnd)));
        start = valEnd + 1;
        root.left = constructHelper(s);
        root.right = constructHelper(s);
        return root;
    }

    public static void main(String[] args) {
        String input = "30 10 50 # # # 20 45 # # 35 # # ";
        assert input.equals(serialize(deserialize(input)));
    }
}