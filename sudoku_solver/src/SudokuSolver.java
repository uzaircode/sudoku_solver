
// sudoku solver
// STATUS : WORKING
// OUTPUT : Completed solution with grids OR No solution

public class SudokuSolver {
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        int[][] board = {
                { 7, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 9, 5, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
                { 0, 0, 0, 7, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 7, 0, 0, 0, 0, 0, 0 }

                // unsolvable
                // {9, 1, 7, 0, 0, 3, 0, 2, 0},
                // {3, 0, 2, 6, 0, 0, 8, 5, 0},
                // {0, 8, 0, 1, 0, 9, 4, 0, 7},
                // {0, 3, 8, 0, 4, 0, 1, 0, 0},
                // {5, 6, 1, 9, 3, 0, 0, 0, 0},
                // {7, 2, 0, 8, 0, 5, 0, 0, 4},
                // {0, 9, 0, 0, 7, 4, 0, 0, 2},
                // {1, 0, 0, 0, 9, 2, 0, 0, 0},
                // {0, 5, 0, 0, 0, 0, 0, 7, 0}
        };

        // getting a random and newly generated sudoku
        // int[][] board = RandomSudoku.generateRandomSudoku();
        // int[][] board = SudokuGenerator.generate();
        System.out.print("\nThe Sudoku Board : ");
        printBoard(board);
        
        if (solveBoard(board)) {
            System.out.print("\n\nSolve Successfully");

        } else {

            System.out.print("\n\nUnsolvable board");
        }
        printBoard(board);

    }

    // for the sake of grids and . in sudoku boards
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

    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {

                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInCollumn(int[][] board, int number, int col) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == number) {

                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int col) {
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxCol; j < localBoxCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int col) {
        return !isNumberInRow(board, number, row) && !isNumberInCollumn(board, number, col)
                && !isNumberInBox(board, number, row, col);

    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, col)) {
                            board[row][col] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }

                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

}
