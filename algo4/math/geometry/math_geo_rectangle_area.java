package geometry;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/rectangle-area/}
 *
 */
public class math_geo_rectangle_area
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        long lA = A,
             lB = B,
             lC = C,
             lD = D,
             lE = E,
             lF = F,
             lG = G,
             lH = H;

        long collideX = Math.max(0L, Math.min(lC, lG) - Math.max(lE, lA)),
             collideY = Math.max(0L, Math.min(lD, lH) - Math.max(lB, lF));

        return (int) ((lC - lA) * (lD - lB) + (lG - lE) * (lH - lF) - collideX * collideY);
    }
}
