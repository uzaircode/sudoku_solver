
// sudoku solver
// STATUS : WORKING
// OUTPUT : Completed solution with grids OR No solution

public class SudokuSolver16x16 {
    private static final int GRID_SIZE = 16; // for 16x16 board
    public static long totalTime = 0;

    public static void startGame(int[][] board) {

        System.out.print("\nThe Sudoku Board : ");
        printBoard(board);

        // count Duration before and after calling solveBoard
        long start = System.currentTimeMillis();
        if (solveBoard(board)) {
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("\n\nDuration (s): " + time / 1000.0);
            totalTime += time;
            System.out.print("\nSolve Successfully");
        } else {

            System.out.print("\n\nUnsolvable board");
        }
        printBoard(board);
    }

    // for the sake of grids and . in sudoku boards
    public static void printBoard(int[][] board) {
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print("\n");
            if (i % 4 == 0)
                System.out.print("-----------------------------------------\n");
            for (int j = 0; j < GRID_SIZE; j++) {
                if (j % 4 == 0)
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
                if (board[i][j] == 10)
                    System.out.print("A ");
                if (board[i][j] == 11)
                    System.out.print("B ");
                if (board[i][j] == 12)
                    System.out.print("C ");
                if (board[i][j] == 13)
                    System.out.print("D ");
                if (board[i][j] == 14)
                    System.out.print("E ");
                if (board[i][j] == 15)
                    System.out.print("F ");
                if (board[i][j] == 16)
                    System.out.print("G ");
            }
            System.out.print("| ");
        }
        System.out.print("\n-----------------------------------------");

    }
    
    // check if number is in row
    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {

                return true;
            }
        }
        return false;
    }

    // check if number is in column
    private static boolean isNumberInColumn(int[][] board, int number, int col) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == number) {

                return true;
            }
        }
        return false;
    }

    // check if number is in box
    private static boolean isNumberInBox(int[][] board, int number, int row, int col) {
        int localBoxRow = row - row % 4;
        int localBoxCol = col - col % 4;

        for (int i = localBoxRow; i < localBoxRow + 4; i++) {
            for (int j = localBoxCol; j < localBoxCol + 4; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    // check if number is in valid placement
    private static boolean isValidPlacement(int[][] board, int number, int row, int col) {
        return !isNumberInRow(board, number, row) && !isNumberInColumn(board, number, col)
                && !isNumberInBox(board, number, row, col);

    }

    // process to solve board - backtrackking algorithm
    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, col)) {
                            board[row][col] = numberToTry;

                            // the recursive call
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
