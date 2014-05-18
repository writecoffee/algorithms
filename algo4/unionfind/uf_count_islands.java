public class uf_count_islands {
    private static class Union {
        private int label;

        Union(int _label) {
            label = _label;
        }
    }

    /**
     * We use union-find data structure for storing "group" info.
     * 
     * For grid entry g[i, j], if g[i, j - 1] is also a "0", then we can simply
     * inherit that from its left entry.
     * 
     * If g[i - 1, j] is also a "0", then we inherit the upper entry's group if
     * g[i, j - 1] is a "1" otherwise "fuse" the upper group and left group
     * together by changing the upper group's label to that of left group.
     * 
     */
    public static int countIslands(int[][] matrix) {
        int count = 0;
        int m = matrix.length, n = matrix[0].length;

        Union[] uf = new Union[n];
        if (matrix[0][0] == 0) {
            uf[0] = new Union(count++);
        }

        for (int j = 1; j < n; ++j) {
            if (matrix[0][j] == 0 && matrix[0][j - 1] == 0) {
                uf[j] = uf[j - 1];
            } else if (matrix[0][j] == 0) {
                uf[j] = new Union(count++);
            }
        }

        for (int i = 1; i < m; ++i) {
            if (matrix[i - 1][0] == 1 && matrix[i][0] == 0) {
                uf[0] = new Union(count++);
            }

            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    continue;
                }

                if (matrix[i][j - 1] == 1 && matrix[i - 1][j] == 1) {
                    uf[j] = new Union(count++);
                } else if (matrix[i][j - 1] == 0 && matrix[i - 1][j] == 0) {
                    if (uf[j].label != uf[j - 1].label) {
                        uf[j].label = uf[j - 1].label;
                        count--;
                    }
                } else if (matrix[i][j - 1] == 0) {
                    uf[j] = uf[j - 1];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countIslands(new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 0 }
        }));
        System.out.println(countIslands(new int[][] {
                        { 1, 0, 1 },
                        { 0, 1, 0 },
                        { 1, 0, 1 }
        }));
        System.out.println(countIslands(new int[][] {
                        { 1, 0, 0 },
                        { 0, 1, 0 },
                        { 1, 0, 1 }
        }));
        System.out.println(countIslands(new int[][] {
                        { 1, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 0 }
        }));
    }
}