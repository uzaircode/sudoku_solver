import java.util.Random;

public class FINALsudokuSolver {
    static int n = 9; // size of the board (9x9)
    static int[][] board = new int[n][n]; // initialize the board

    public static void main(String[] args) {
        generateBoard(); // generate the board
        removeElements(); // remove elements from the board
        printBoard(); // print the final board
    }

    // generate the full, solved board
    static void generateBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (i * n + i / n + j) % (n + 1) + 1;
            }
        }
        shuffleRows();
        shuffleColumns();
        shuffleNumbers();
    }

     // shuffle the rows
     static void shuffleRows() {
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int row = rnd.nextInt(n);
            int[] temp = board[i];
            board[i] = board[row];
            board[row] = temp;
        }
    }

    // shuffle the columns
    static void shuffleColumns() {
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int column = rnd.nextInt(n);
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                temp[j] = board[j][i];
            }
            for (int j = 0; j < n; j++) {
                board[j][i] = board[j][column];
            }
            for (int j = 0; j < n; j++) {
                board[j][column] = temp[j];
            }
        }
    }

    // shuffle the numbers
    static void shuffleNumbers() {
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int num1 = rnd.nextInt(n) + 1;
            int num2 = rnd.nextInt(n) + 1;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[j][k] == num1) {
                        board[j][k] = num2;
                    } else if (board[j][k] == num2) {
                        board[j][k] = num1;
                    }
                }
            }
        }
    }

    // CONTINUE HERE

    // remove elements from the board while maintaining its solvability
    static void removeElements() {
        // logic to remove elements while maintaining solvability
    }

    // print the board
    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
