package circle;

public class josephus_ring {
    /**
     * For the general case where k is an arbitrary number, we use F(n, k) to denote the solution
     * for n persons. Then we have F(n, k) = (F(n - 1, k) + k) % n.
     * 
     * The first person we need to eliminate is the kth person, after he is removed, we have n - 1
     * persons now.
     * 
     * However, we can not directly resort to the subproblem F(n - 1, k), since now our process will
     * start at the (k + 1)th person at the original circle. Therefore we need to remap the indices.
     * Since the process is applied on a circle, we can think of concatenating the first k - 1
     * persons to the end of the circle.
     * 
     * Thus, assume the new index in F(n - 1, k) is i, the corresponding index in F(n, k) is (i + k) % n.
     * 
     * After computation, we can restore the problem such that we always eliminate the first person.
     * 
     */
    public int getSurvivor(int n, int k) {
        return (get(n, k) + n - (k - 1)) % n + 1;
    }

    private int get(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (get(n - 1, k) + k) % n;
    }
}