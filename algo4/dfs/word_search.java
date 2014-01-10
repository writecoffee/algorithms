
public class word_search {
    public static boolean exist(char[][] board, String word) {
        int N = board.length;
        int M = board[0].length;
        char[][] available = new char[N][M];
        for (int i = 0; i < available.length; i++) {
            for (int j = 0; j < available[i].length; j++) {
                available[i][j] = 'o';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (existsHelper(board, word, 0, i, j, available)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean existsHelper(char[][] board, String word, int wordStrIndex, int i, int j, char[][] available) {
        int N = board.length;
        int M = board[0].length;
        if (wordStrIndex == word.length()) {
            return true;
        }

        if (i < 0 || i >= N || j < 0 || j >= M) {
            return false;
        }

        if (board[i][j] != word.charAt(wordStrIndex) || available[i][j] == 'x') {
            return false;
        }

        available[i][j] = 'x';
        if (existsHelper(board, word, wordStrIndex + 1, i - 1, j, available)) {
            return true;
        }
        if (existsHelper(board, word, wordStrIndex + 1, i + 1, j, available)) {
            return true;
        }
        if (existsHelper(board, word, wordStrIndex + 1, i, j - 1, available)) {
            return true;
        }
        if (existsHelper(board, word, wordStrIndex + 1, i, j + 1, available)) {
            return true;
        }
        available[i][j] = 'o';

        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                        exist(new char[][] {
                             { 'A', 'B', 'C', 'E' },
                             { 'S', 'F', 'C', 'S' },
                             { 'A', 'D', 'E', 'E' } },
                        "SEE"));
    }
}