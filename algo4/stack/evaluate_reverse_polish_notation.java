import java.util.Stack;

public class evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<String>();
        int n = tokens.length;
        for (int i = 0; i < n; ++i) {
            Character c = tokens[i].charAt(0);

            if (Character.isDigit(c) || ((c == '-' || c == '+') && tokens[i].length() > 1)) {
                s.push(tokens[i]);
                continue;
            }

            String r = s.pop();
            String l = s.pop();
            Integer t;
            switch (c) {
            case '+':
                t = Integer.parseInt(l) + Integer.parseInt(r);
                s.push(t.toString());
                break;
            case '-':
                t = Integer.parseInt(l) - Integer.parseInt(r);
                s.push(t.toString());
                break;
            case '*':
                t = Integer.parseInt(l) * Integer.parseInt(r);
                s.push(t.toString());
                break;
            case '/':
                t = Integer.parseInt(l) / Integer.parseInt(r);
                s.push(t.toString());
                break;
            default:
                break;
            }
        }

        return Integer.parseInt(s.pop());
    }
}