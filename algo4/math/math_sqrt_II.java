/**
 * Implement double sqrt(double x).
 * 
 * Compute and return the square root of x.
 * 
 * [Difficulty] - Medium
 * [Source]     - Classical Problem
 * 
 */
public class math_sqrt_II {
    /**
     * Newton's method is to approximate Sqrt(x) by picking a starting point z and then
     * repeating:
     * 
     *      z = z - (z^2 - x) / 2 / z
     *
     */
    public double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("x must be bigger than 0");
        }

        double z = x / 2,
               delta = 0.0001;

        for (double zn = 0.0; Math.abs(zn - z) > delta; zn = z, z = z - (z * z - x) / 2 / z) { }

        return z;
    }
}
