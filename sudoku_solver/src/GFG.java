import java.util.Arrays;

public class GFG {
    private int[][] board;

    public GFG(int[][] board) {
        this.board = board;
    }

    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] square = new int[9];
            int[] column = board[i].clone();

            for (int j = 0; j < 9; j++) {
                row[j] = board[j][i];
                square[j] = board[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (!(validate(column) && validate(row) && validate(square)))
                return false;
        }
        return true;
    }

    private boolean validate(int[] check) {
        int i = 0;
        Arrays.sort(check);
        for (int number : check) {
            if (number != ++i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
            { 7, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 9, 5, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
            { 0, 0, 0, 7, 0, 0, 0, 0, 5 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 7, 0, 0, 0, 0, 0, 0 }
        };
        GFG sudoku = new GFG(board);

        System.out.println("Is the board valid? " + sudoku.isValid());
    }
}
