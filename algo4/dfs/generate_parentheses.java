import java.util.ArrayList;


public class generate_parentheses {

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }

        String str = "";
        getParenthesis(n, n, str, result);

        return result;
    }

    public static void getParenthesis(int leftCounter, int rightCounter, String str, ArrayList<String> result) {
        if (leftCounter == 0 && rightCounter == 0) {
            result.add(str);
            return;
        }

        if (leftCounter == 0) {
            getParenthesis(0, rightCounter - 1, str + ")", result);
        } else if (leftCounter > 0) {
            getParenthesis(leftCounter - 1, rightCounter, str + "(", result);
            if (rightCounter > leftCounter) {
                getParenthesis(leftCounter, rightCounter - 1, str + ")", result);
            }
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}