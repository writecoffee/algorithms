import java.util.List;

import com.google.common.collect.Lists;


/**
 * Given a list of two-dimensional rectangles, compute the area of their union.
 * For example, the union of the three rectangles shown in the figure below:
 *
 * cover an area of 35 units.
 *
 * The list of rectangles will be given as a vector <string>, where each element
 * describes one rectangle.  Each string will be formatted as 4 space-separated
 * integers with no leading zeros, giving the coordinates of the left, bottom, right,
 * and top of the rectangle (in that order).
 *
 * The three rectangles shown above would be given as:
 *
 *
 *
 *     { "1 3 5 6",
 *       "3 1 7 5",
 *       "4 4 9 7" }
 *
 * CONSTRAINTS
 *
 * - rectangles will contain between 1 and 3 elements, inclusive.
 * - Each element of rectangles will be formatted as described in the problem statement.
 * - For each rectangle, the left coordinate will be less than the right coordinate and the bottom coordinate will be less than the top coordinate.
 * - All coordinates will be between 0 and 20000, inclusive.
 *
 * EXAMPLES
 *
 * 0)
 * { "200 300 203 304" }
 *
 * Returns: 12
 *
 * A single rectangle with area 12.
 *
 * 1)
 * { "0 0 10 10",
 *   "20 20 30 30" }
 *
 * Returns: 200
 *
 * Two disjoint rectangles, each of area 100.
 *
 * 2)
 * { "0 500 20000 501",
 *   "500 0 501 20000" }
 *
 * Returns: 39999
 *
 * These two rectangles intersect at a single point.
 *
 * 3)
 * { "4 6 18 24",
 *   "7 2 12 19",
 *   "0 0 100 100" }
 *
 * Returns: 10000
 *
 * The third rectangle completely overlaps the first two.
 *
 * 4)
 * { "1 3 5 6",
 *   "3 1 7 5",
 *   "4 4 9 7" }
 *
 * Returns: 35
 *
 * This is the example from the problem statement.
 *
 * 5)
 * { "0 0 20000 20000",
 *   "0 0 20000 20000",
 *   "0 0 20000 20000" }
 *
 * Returns: 400000000
 *
 * [Source]     - topcoder {@linkplain http://topcoder.bgcoder.com/print.php?id=871}, google interview
 * [Difficulty] - Hard
 * [Tag]        - $line sweeping$, $geometry$
 *
 */
public class geo_calculate_union_area_of_rectangles
{
    public static class Rectangle
    {
        public final int x;
        public final int y;
        public final int width;
        public final int height;

        public Rectangle(int x, int y, int width, int height)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public int getArea()
        {
            return width * height;
        }

        public Rectangle intersect(Rectangle other)
        {
            int newX0 = Math.max(x, other.x);
            int newY0 = Math.max(y, other.y);

            int newX1 = Math.min(x + width, other.x + other.width);
            int newY1 = Math.min(y + height, other.y + other.height);

            if (newX1 <= newX0 && newY1 <= newY0) {
                return null;
            }

            return new Rectangle(newX0, newY0, newX1 - newX0, newY1 - newY0);
        }
    }

    /**
     * Basic solution idea:
     *
     * Derive recursive function:
     *
     * Let b1, b2, ..., bn denote the box number respectively. In short, we can
     * use 1 to denote b1, and etc.
     *
     * Let
     *
     *      R_{1..n} = R_1 + R_{2..n} - R{I_12, I_13, .., I_1n}
     *        (1)             (2)                (3)
     *
     * where "R" denotes the union area of the input boxes. We can attack this
     * problem from the simplest case with only two regions, A and B, where the
     * second region/box can be treated as an imaginary union of all the remaining
     * boxes except box A.
     *
     * "I" denotes the intersection area of two boxes.
     *
     * We can visualize the recursive calling into a tree, where at level i it is of
     * 2^i computation cost (notice that box array input (2) and (3) are of the same
     * length). So the time complexity is O(2^n).
     *
     */
    public static int unionArea(List<Rectangle> rectangles)
    {
        if (rectangles.size() == 0) {
            return 0;
        }

        if (rectangles.size() == 1) {
            return rectangles.get(0).getArea();
        }

        Rectangle a = rectangles.get(0);
        List<Rectangle> subList = rectangles.subList(1, rectangles.size());

        int areaA = a.getArea();
        int areaB = unionArea(subList);

        List<Rectangle> intersect = Lists.newArrayList();

        for (Rectangle rect : subList) {
            Rectangle newRect = a.intersect(rect);

            if (newRect != null) {
                intersect.add(newRect);
            }
        }

        return areaA + areaB - unionArea(intersect);
    }
}
