import java.util.Random;

// STATUS : NOT RUNNING

public class SudokuGenerator {
    private int[][] sudoku = new int[9][9];
    private Random random = new Random();

	public static void main(String args[])
    {
        SudokuGenerator obj = new SudokuGenerator();
        int[][] board = obj.generate();
        printBoard(board);
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            System.out.print("\n");
            if (i % 3 == 0)
                System.out.print("-------------------------\n");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0)
                    System.out.print("| ");
                if (board[i][j] == 0)
                    System.out.print(". ");
                if (board[i][j] == 1)
                    System.out.print("1 ");
                if (board[i][j] == 2)
                    System.out.print("2 ");
                if (board[i][j] == 3)
                    System.out.print("3 ");
                if (board[i][j] == 4)
                    System.out.print("4 ");
                if (board[i][j] == 5)
                    System.out.print("5 ");
                if (board[i][j] == 6)
                    System.out.print("6 ");
                if (board[i][j] == 7)
                    System.out.print("7 ");
                if (board[i][j] == 8)
                    System.out.print("8 ");
                if (board[i][j] == 9)
                    System.out.print("9 ");
            }
            System.out.print("| ");
        }
        System.out.print("\n-------------------------");

    }

    public int[][] generate() {
        generateNumbers();
        return sudoku;
    }

    private void generateNumbers() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = random.nextInt(9) + 1;
                while (!isValid(i, j, num)) {
                    num = random.nextInt(9) + 1;
                }
                sudoku[i][j] = num;
            }
        }
    }

    private boolean isValid(int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int subgridRow = (row / 3) * 3;
        int subgridCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[subgridRow + i][subgridCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
