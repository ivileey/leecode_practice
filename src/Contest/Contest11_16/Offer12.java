package Contest.Contest11_16;

/**
 * @description:
 * @author: Yuner
 * @create: 2020-11-16 19:08
 **/
public class Offer12 {
    //dfs
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 ||j >= board[0].length || board[i][j] != word.charAt(k))
            return false;

        if (k == word.length() - 1)
            return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j - 1, k  + 1) || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}
