import java.util.Stack;
import java.util.ArrayList;

/**
 * Given a grid of x's and o's, where x's are walls and o's are a path, find
 * the shortest path between two points on the path which does not step onto
 * a wall. An example grid, with two points of interest on the path (bold),
 * could be:
 *
 *   ===========> Increasing X
 * ||  o o o o o   
 * ||  x o x o x
 * ||  x o o x o
 * ||  x x o x x
 * ||  x o o x x
 * \/
 * Increasing Y
 *
 *
 * Note:
 *
 * 1. The steps in the path can only horizontal or vertical. 
 * 2. The input grid is in a text file
 * 
 * [Difficulty]	- Medium
 * [Source]		- google interview
 * 
 */
public class dfs_search_shortest_path_in_maze {
	private class Point {
		private final int x, y;
		private Point(int _x, int _y) {
			x = _x;
			y = _y;
		}
	}

	public ArrayList<Point> searchShortestPath(int startX, int startY, int endX, int endY, char[][] grid) {
		ArrayList<Point> minPath = new ArrayList<Point>();
		explore(grid, grid.length, grid[0].length, startX, startY, endX, endY, new Stack<Point>(), minPath);
		return minPath;
	}

	private void explore(char[][] grid, int m, int n, int startX, int startY, int endX, int endY, Stack<Point> path, ArrayList<Point> minPath) {
		if (startX < 0 || startX == n || startY < 0 || startY == m || grid[startY][startX] == 'x' || grid[startY][startX] == 'v') {
			return;
		} else if (startX == endX && startY == endY) {
			if (minPath.isEmpty() || path.size() < minPath.size()) {
				minPath = new ArrayList<Point>(path);
				minPath.add(new Point(endX, endY));
			}

			return;
		}

		grid[startY][startX] = 'v';
		path.push(new Point(startX, startY));

		explore(grid, m, n, startX + 1, startY, endX, endY, path, minPath);
		explore(grid, m, n, startX, startY + 1, endX, endY, path, minPath);
		explore(grid, m, n, startX - 1, startY, endX, endY, path, minPath);
		explore(grid, m, n, startX, startY - 1, endX, endY, path, minPath);

		path.pop();
		grid[startY][startX] = 'o';
	}
}
