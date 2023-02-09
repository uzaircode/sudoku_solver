import java.util.Random;

public class Random16x16Sudoku {
    static char[][] sudoku = new char[16][16];
    static Random random = new Random();
    static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    
    public static void main(String[] args) {
        generateRandomSudoku();
        printSudoku();
    }

    private static void generateRandomSudoku() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                sudoku[i][j] = '0';
            }
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNumber = random.nextInt(16);
                if (isValid(i, j, digits[randomNumber])) {
                    sudoku[i][j] = digits[randomNumber];
                // } else {
                //     j--;
                }
            }
        }
    }

    private static boolean isValid(int row, int col, char num) {
        for (int i = 0; i < 16; i++) {
            if (sudoku[row][i] == num || sudoku[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(16);
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
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
