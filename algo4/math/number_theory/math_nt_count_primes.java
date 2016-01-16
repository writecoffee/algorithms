package number_theory;

/**
 * Description:
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/count-primes/}
 * [Difficulty] - Medium
 *
 */
public class math_nt_count_primes
{
    public int countPrimes(int n)
    {
        int count = 0;
        boolean[] used = new boolean[n];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!used[i - 1]) {
                int probe = i * i;

                while (probe < n) {
                    used[probe - 1] = true;
                    probe += i;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!used[i - 1]) {
                count++;
            }
        }

        return count;
    }
}
