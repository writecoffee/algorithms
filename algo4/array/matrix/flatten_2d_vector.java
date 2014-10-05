package matrix;

import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 *
 * For example,
 *
 * Given 2d vector =
 *
 * [
 *   [1,2],
 *   [3],
 *   [4,5,6]
 * ]
 *
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 *
 * Hint:
 *
 * 1. How many variables do you need to keep track?
 *
 * 2. Two variables is all you need. Try with x and y.
 *
 * 3. Beware of empty rows. It could be the first few rows.
 *
 * 4. To write correct code, think about the invariant to maintain. What is it?
 *
 * 5. The invariant is x and y must always point to a valid point in the 2d vector.
 *    Should you maintain your invariant ahead of time or right when you need it?
 *
 * 6. Not sure? Think about how you would implement hasNext(). Which is more complex?
 *
 * 7. Common logic in two different places should be refactored into a common method.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/flatten-2d-vector/}
 * [Difficulty] - Medium
 * [Tag]        - $iterator$
 *
 */
public class flatten_2d_vector
{
    public class Vector2D
    {
        int row = 0,
            col = 0;

        List<List<Integer>> vector;

        public Vector2D(List<List<Integer>> vec2d)
        {
            vector = vec2d;
        }

        public int next()
        {
            return vector.get(row).get(col++);
        }

        public boolean hasNext()
        {
            while (row < vector.size() && col == vector.get(row).size()) {
                row++;
                col = 0;
            }

            return row < vector.size() && col < vector.get(row).size();
        }
    }
}
