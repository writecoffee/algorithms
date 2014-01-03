
import java.util.Stack;

public class valid_parentheses {
    
    static boolean isValid(String s) {
        Stack<Character> matchingStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                matchingStack.push(s.charAt(i));
            } else {
                if (matchingStack.empty() || Math.abs(matchingStack.pop() - s.charAt(i)) > 2) {
                    return false;
                }
            }
        }

        return matchingStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
    }
}
