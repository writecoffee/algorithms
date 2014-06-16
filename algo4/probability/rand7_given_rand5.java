import java.util.Random;

/**
 * Implement a method rand7() given rand5(). That is, given a method that generates a random number
 * between 0 and 4 (inclusive), write a method that generates a random number between 0 and 6
 * (inclusive).
 * 
 * [Difficulty] - Medium
 * [Source]     - cc150-17.11
 * 
 */
public class rand7_given_rand5 {
    public int rand7() {
        while (true) {
            int val = 5 * rand5() + rand5();

            if (val < 21) {
                return val % 7;
            }
        }
    }

    public int rand5() {
        return new Random().nextInt(5);
    }
}