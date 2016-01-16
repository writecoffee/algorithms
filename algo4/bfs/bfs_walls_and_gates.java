package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * 1. -1 - A wall or an obstacle.
 *
 * 2. 0 - A gate.
 *
 * 3. INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647
 *    to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *    Fill each empty room with the distance to its nearest gate. If it is impossible
 *    to reach a gate, it should be filled with INF.
 *
 * For example, given the 2D grid:
 *
 *   INF  -1  0  INF
 *   INF INF INF  -1
 *   INF  -1 INF  -1
 *     0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/walls-and-gates/}
 * [Difficulty] - Medium
 *
 */
public class bfs_walls_and_gates
{
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length,
            n = rooms[0].length;

        List<Integer> gates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    gates.add(i * n + j);
                }
            }
        }

        for (int gate : gates) {
            Queue<Integer> p = new LinkedList<>();
            p.add(gate);
            Set<Integer> visited = new HashSet<>();
            int level = 0;

            while (!p.isEmpty()) {
                Queue<Integer> np = new LinkedList<>(p);
                p.clear();

                while (!np.isEmpty()) {
                    int next = np.poll();
                    visited.add(next);
                    rooms[next / n][next % n] = Math.min(rooms[next / n][next % n], level);

                    for (int neighbor : getNeighbor(rooms, next, m, n, visited)) {
                        p.add(neighbor);
                    }
                }

                level++;
            }
        }
    }

    private int[][] neighborOffset = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private List<Integer> getNeighbor(int[][] rooms, int next, int m, int n, Set<Integer> visited)
    {
        List<Integer> result = new ArrayList<>();

        for (int[] offset : neighborOffset) {
            int y = next / n + offset[0],
                x = next % n + offset[1];

            if (y >= 0 && x >= 0 && x < n && y < m && !visited.contains(y * n + x) && rooms[y][x] > 0) {
                result.add(n * y + x);
            }
        }

        return result;
    }
}
