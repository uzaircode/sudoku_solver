import java.util.Random;

// STATUS : WORKING
// OUTPUT : generating 9x9 random, completed sudoku boards - with WRONG answers

public class RandomSudoku2 {
    static int[][] sudoku = new int[9][9];
    static Random random = new Random();
    
    public static void main(String[] args) {
        generateRandomSudoku();
        printSudoku(sudoku);
    }

    private static void generateRandomSudoku() {
        for (int i = 0; i < 9; i++) {
            
            for (int j = 0; j < 9; j++) {
                
                int randomNumber = random.nextInt(9) + 1;
                sudoku[i][j] = randomNumber;
            }
        }
    }

    public static void printSudoku(int[][] board) {
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
}
