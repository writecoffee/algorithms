public class palindromic_number {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int div = 10;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x >= 10) {
            int msd = x / div;
            int lsd = x % 10;

            if (msd != lsd) {
                return false;
            }

            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }
}