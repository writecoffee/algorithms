package plane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in
 * the group. The distance is calculated using Manhattan Distance,
 * where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * For example, given three people living at (0,0), (0,4), and (2,2):
 *
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6
 * is minimal. So return 6.
 *
 * Hint:
 *
 * Try to solve it in one dimension first. How can this solution apply to the two
 * dimension case?
 *
 */
public class math_plane_best_meeting_point
{
    public int minTotalDistance(int[][] grid)
    {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    listX.add(i);
                    listY.add(j);
                }
            }
        }

        int ret = 0;
        Collections.sort(listX);
        Collections.sort(listY);
        int pivotX = listX.get(listX.size() / 2);
        int pivotY = listY.get(listY.size() / 2);

        for (Integer x : listX) {
            ret = ret + Math.abs(x - pivotX);
        }

        for (Integer y : listY) {
            ret = ret + Math.abs(y - pivotY);
        }

        return ret;
    }
}
