import java.util.Random;

/**
 * To simplify proof, let us first consider the last element, the last element replaces the
 * previously stored result with 1/n probability. So probability of getting last element as result
 * is 1/n.
 * 
 * Let us now talk about second last element. When second last element processed first time, the
 * probability that it replaced the previous result is 1/(n-1). The probability that previous result
 * stays when nth item is considered is (n-1)/n. So probability that the second last element is
 * picked in last iteration is [1/(n-1)] * [(n-1)/n] which is 1/n.
 * 
 * [Difficulty] - Medium
 * [Source]     - turn interview,
 *                {@linkplain http://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/}
 * 
 */
public class select_a_random_number_from_a_stream {
    private int x = -1;
    private int count = 0;
    private Random r = new Random();

    public void receiveNumber(int freshNumber) {
        count++;

        if (count > 1) {
            if (r.nextInt(count) == count - 1) {
                x = freshNumber;
            }
        }
    }

    public int getNumber() {
        return x;
    }
}