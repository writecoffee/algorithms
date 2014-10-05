import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Answer: 3
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/number-of-islands/}
 * [Difficulty] - Medium
 *
 */
public class uf_count_islands
{
    /**
     * We are visiting nodes from left to right, from up to bottom.
     *
     * We need to guarantee that all nodes in one island will converge into one single node,
     * which is the leader. So we can simply let the most recently visited node to become leader,
     * let its neighbor (adjacent on left, or adjacent above) to pointer to itself and elect it
     * to be the leader.
     *
     */
    public int numIslands(char[][] matrix)
    {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int count = 0;
        int m = matrix.length, n = matrix[0].length;

        Map<Integer, Integer> leader = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                count += 1;
                int index = i * n + j;
                leader.put(index, index);

                for (int neighbor : getLeftAndUpNeighbhor(matrix, i, j)) {
                    int nLeader = find(leader, neighbor);
                    if (nLeader != index) {
                        count--;
                    }

                    leader.put(nLeader, index);
                }
            }
        }

        return count;
    }

    private List<Integer> getLeftAndUpNeighbhor(char[][] matrix, int i, int j)
    {
        List<Integer> result = new ArrayList<>();
        int n = matrix[0].length;

        if (i != 0 && j != 0) {
            if (matrix[i][j - 1] == '1') {
                result.add(i * n + j - 1);
            }
            if (matrix[i - 1][j] == '1') {
                result.add((i - 1) * n + j);
            }
        } else if (i != 0) {
            if (matrix[i - 1][j] == '1') {
                result.add((i - 1) * n + j);
            }
        } else if (j != 0) {
            if (matrix[i][j - 1] == '1') {
                result.add(i * n + j - 1);
            }
        }

        return result;
    }

    private int find(Map<Integer, Integer> leader, int x)
    {
        while (leader.get(x) != x) {
            x = leader.get(x);
        }

        return x;
    }
}
