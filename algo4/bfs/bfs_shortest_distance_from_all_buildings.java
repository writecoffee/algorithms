package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You want to build a house on an empty land which reaches all buildings in the
 * shortest amount of distance. You can only move up, down, left and right.
 * You are given a 2D grid of values 0, 1 or 2, where:
 *
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 *
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * The point (1,2) is an ideal empty land to build a house, as the total travel
 * distance of 3+3+1=7 is minimal. So return 7.
 *
 * Note:
 * There will be at least one building. If it is not possible to build such house
 * according to the above rules, return -1.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/shortest-distance-from-all-buildings/}
 * [Difficulty] - Hard
 *
 */
public class bfs_shortest_distance_from_all_buildings
{
    public int shortestDistance(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visitedCount = new int[m][n];
        int[][] distances = new int[m][n];
        int buildingCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingCount++;
                    bfs(visitedCount, distances, grid, i, j, m, n);
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visitedCount[i][j] == buildingCount) {
                    result = Math.min(result, distances[i][j]);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    private void bfs(int[][] visitedCount, int[][] distances, int[][] grid, int i, int j, int m, int n)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(i * n + j);
        int level = 1;

        Set<Integer> visited = new HashSet<>();
        visited.add(i * n + j);

        while (!q.isEmpty()) {
            Queue<Integer> p = new LinkedList<>(q);
            q.clear();

            while (!p.isEmpty()) {
                Integer c = p.poll();
                int cx = c % n;
                int cy = c / n;

                for (int[] dir : dirs) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    int pint = ny * n + nx;

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited.contains(pint) || grid[ny][nx] == 2 || grid[ny][nx] == 1) {
                        continue;
                    }

                    q.add(pint);
                    visitedCount[ny][nx]++;
                    distances[ny][nx] += level;
                    visited.add(pint);
                }
            }

            level++;
        }
    }
}
