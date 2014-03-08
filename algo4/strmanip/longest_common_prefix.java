public class longest_common_prefix {
    String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs.length == 0) {
            return result.toString();
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return result.toString();
                }
            }

            result.append(ch);
        }

        return result.toString();
    }
}