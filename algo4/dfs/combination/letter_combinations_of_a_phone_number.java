package combination;

import java.util.ArrayList;
import java.util.Stack;

public class letter_combinations_of_a_phone_number {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        String[] mappings = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        explore(mappings, digits, new StringBuilder(), result);
        return result;
    }

    private void explore(String[] mappings, String digits, StringBuilder nxt, ArrayList<String> result) {
        int i = nxt.length();

        if (nxt.length() == digits.length()) {
            result.add(nxt.toString());
            return;
        }

        char[] chrs = mappings[digits.charAt(i) - '2'].toCharArray();
        for (char j : chrs) {
            nxt.append(j);
            explore(mappings, digits, nxt, result);
            nxt.deleteCharAt(nxt.length() - 1);
        }
    }

    public ArrayList<String> letterCombinationsNonrecur(String digits) {
        int n = digits.length();
        String[] mappings = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            result.add("");
            return result;
        }

        StringBuilder nxt = new StringBuilder();
        nxt.append(mappings[digits.charAt(0) - '2'].charAt(0));
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);

        while (true) {
            if (s.peek() == mappings[digits.charAt(s.size() - 1) - '2'].length()) {
                if (s.size() == 1) {
                    break;
                }

                s.pop();
                s.push(s.pop() + 1);
                nxt.deleteCharAt(nxt.length() - 1);
                char oldChar = nxt.charAt(nxt.length() - 1);
                nxt.deleteCharAt(nxt.length() - 1);
                nxt.append((char) (oldChar + 1));
            } else if (s.size() == n) {
                result.add(nxt.toString());
                s.push(s.pop() + 1);
                char oldChar = nxt.charAt(n - 1);
                nxt.deleteCharAt(n - 1);
                nxt.append((char) (oldChar + 1));
            } else {
                nxt.append(mappings[digits.charAt(s.size()) - '2'].charAt(0));
                s.push(0);
            }
        }

        return result;
    }
}