public class evaluate_expression {
    public int evaluateNonrecur(String expr) {
        int result = 0;
        int n = expr.length();
        int k = 1;

        for (int i = 0; i < n; ++i) {
            int t = 0;
            while (i < n && expr.charAt(i) >= '0' && expr.charAt(i) <= '9') {
                t = t * 10 + (expr.charAt(i++) - '0');
            }
            k *= t;

            if (i == n) {
                result += k;
            } else if (expr.charAt(i) == '+') {
                result += k;
                k = 1;
            } else if (expr.charAt(i) == '-') {
                result += k;
                k = -1;
            }
        }

        return result;
    }

    public int evaluate(String expr, int i, int k) {
        int n = expr.length();
        int t = 0;
        while (i < n && expr.charAt(i) >= '0' && expr.charAt(i) <= '9') {
            t = t * 10 + (expr.charAt(i++) - '0');
        }
        k *= t;

        if (i == n) {
            return k;
        }

        if (expr.charAt(i) == '*') {
            return evaluate(expr, i + 1, k);
        } else if (expr.charAt(i) == '+') {
            return k + evaluate(expr, i + 1, 1);
        } else {
            return k + evaluate(expr, i + 1, -1);
        }
    }

    public int evaluate(String expr) {
        return evaluate(expr, 0, 1);
    }
}