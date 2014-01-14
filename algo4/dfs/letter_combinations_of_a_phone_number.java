import java.util.ArrayList;

public class letter_combinations_of_a_phone_number {

    public static ArrayList<String> letterCombinations(String digits) {
        String[] mappings = { "abc", "def", "ghi", "jkl", "mno", "pgrs", "tuv", "wxyz" };
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        letterCombHelper(digits, mappings, s, result);
        return result;
    }

    static void letterCombHelper(String digits, String[] mappings, StringBuilder s, ArrayList<String> result) {
        if (s.length() == digits.length()) {
            result.add(s.toString());
            return;
        }

        String letters = mappings[digits.charAt(s.length()) - '2'];
        for (int i = 0; i < letters.length(); i++) {
            s.append(letters.charAt(i));
            letterCombHelper(digits, mappings, s, result);
            s.deleteCharAt(s.length() - 1);
        }
    }

    static ArrayList<String> letterCombinationsNonrecur(String digits) {
        String[] mappings = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> result = new ArrayList<String>();

        if (digits == null || digits.isEmpty()) {
            result.add("");
            return result;
        }

        int[] stack = new int[digits.length()];
        int stackPointer = digits.length() - 1;

        while (true) {
            if (stack[stackPointer] >= mappings[digits.charAt(stackPointer) - '2'].length()) {
                if (stackPointer == 0) {
                    break;
                }

                stack[stackPointer] = 0;
                stack[--stackPointer]++;
            } else if (stackPointer == digits.length() - 1) {
                StringBuilder newResult = new StringBuilder();
                for (int i = 0; i < stack.length; i++) {
                    newResult.append(mappings[digits.charAt(i) - '2'].charAt(stack[i]));
                }

                result.add(newResult.toString());
                stack[stackPointer]++;
            } else {
                stackPointer++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        letterCombinations("2323497");
        letterCombinationsNonrecur("23");
    }
}
