
public class pow_x_n {
    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 2) {
            return x * x;
        }
        if (n == 1) {
            return x;
        }
        
        if (n % 2 == 0) {
            return pow(pow(x, n / 2), 2);
        } else {
            if (n > 0) {
                return x * pow(pow(x, n / 2), 2);
            } else {
                return 1 / x * pow(pow(x, n / 2), 2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(99.4f, 2));
    }
}
