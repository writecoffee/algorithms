
public class permutation_sequence {

    static String getPermutation(int n, int k) {
        StringBuilder numberCollection = new StringBuilder();
        StringBuilder result = new StringBuilder();

        int factorialProduct = 1;
        for (int i = 1; i < n + 1; i++) {
            numberCollection.append((char) ('0' + i));
            factorialProduct *= i;
        }

        k--;
        while (n > 0) {
            factorialProduct /= n;
            int numberIndex = k / factorialProduct;
            k %= factorialProduct;
            result.append(numberCollection.charAt(numberIndex));
            numberCollection.delete(numberIndex, numberIndex + 1);
            n--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}