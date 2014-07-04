import java.util.Random;

/**
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle—in other
 * words, each of the 52! permutations of the deck has to be equally likely. Assume that
 * you are given a random number generator which is perfect.
 * 
 * [Difficulty] - Hard
 * [Source]     - google interview, {@linkplain CC150-18.2}
 *
 */
public class shuffle_array {
    /**
     * The idea is to just go through the deck and make one swap at each of the index i, and we swap
     * it with, in equal chance, any item we haven't seen yet, to occur in position i.
     * 
     * We need to prove that at each position i, it can have any element with equal probability.
     * 
     * The probability that ith element (including the last one) goes to the first position is 1 / n,
     * because we randomly pick an element in first iteration.
     * 
     * The probability that ith element goes to second position can be proven to be 1 / n by dividing it
     * into two cases.
     * 
     * (1) i < 1
     *
     *     Prob = ((n - 1) / n)  *  (1 / (n - 1))
     *              ----------       -----------
     *            swapped out of    then being selected
     *            the first slot    to swapped with
     *            in the first      element in the second
     *            iteration         slot
     *
     * (2) i >= 1
     * 
     *     Prob = ((n - 1) / n)  *  (1 / (n - 1))
     *              ----------       -----------
     *            not selected in   then being selected
     *            the first         in the second pass
     *            iteration
     * 
     * We can easily generalize above proof for any other position.
     * 
     */
    public void shuffle(int[] array) {
        int n = array.length;
        Random r = new Random();

        for (int i = 0; i < n - 1; ++i) {
            swap(array, i, i + r.nextInt(n - i));
        }
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}