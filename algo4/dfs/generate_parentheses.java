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

    public static ArrayList<String> generateParenthesisImprov(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }

        int[] stack = new int[2 * n];
        int stackPointer = 0;
        int cl = n;
        int cr = n;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (stackPointer == 2 * n) {
                result.add(sb.toString());
                stackPointer--;
            } else if (stack[stackPointer] > 2) {
                if (stackPointer == 0) {
                    break;
                }

                assert sb.length() == stackPointer + 1;

                stack[stackPointer] = 0;

                if (sb.charAt(stackPointer) == ')') {
                    cr++;
                } else {
                    cl++;
                }

                sb.delete(sb.length() - 1, sb.length());
                stackPointer--;
            } else {
                stack[stackPointer]++;
                if (stack[stackPointer] == 1) {
                    if (cl == 0) {
                        continue;
                    } else {
                        sb.append('(');
                        cl--;
                    }
                } else if (stack[stackPointer] == 2) {
                    boolean backtracked = false;
                    if (sb.length() - 1 == stackPointer) {
                        cl++;
                        sb.delete(sb.length() - 1, sb.length());
                        backtracked = true;
                    }

                    if (cl < cr) {
                        sb.append(')');
                        cr--;
                    } else {
                        stack[stackPointer]++;
                        if (backtracked) {
                            sb.append('(');
                            cl--;
                        }
                        continue;
                    }
                } else {
                    continue;
                }

                stackPointer++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        generateParenthesisImprov(3);
    }
}