import java.util.Random;

public class RandomSudoku {
    static int[][] sudoku = new int[9][9];
    static Random random = new Random();
    
    public static void main(String[] args) {
        generateRandomSudoku();
        printSudoku();
    }

    public static int[][] generateRandomSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = 0;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int randomNumber = random.nextInt(9) + 1;
                if (isValid(i, j, randomNumber)) {
                    sudoku[i][j] = randomNumber;
                // } else {
                //     j--;
                }
            }
        }
        return sudoku;
    }

    private static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            //checking based on row and column if there is duplication
            if (sudoku[row][i] == num || sudoku[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(9);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int c = boxColStart; c < boxColStart + sqrt; c++) {
                if (sudoku[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }


    private static void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
