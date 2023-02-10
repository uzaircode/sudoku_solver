import java.util.ArrayList;

// initializing 9x9 boards - all 'evil' level from https://sudoku.com/evil/
// call 9X9 from main 
// STATUS : WORKING WELL
// OUTPUT : 5 boards with solutions, including duration to complete solution, ended with average of time taken for each board to complete

public class Boards {

    public static void main(String[] args) {
        ArrayList<int[][]> boards = new ArrayList<int[][]>();
        SudokuSolver SS = new SudokuSolver();

        int[][] board1 = {
                { 0, 0, 5, 9, 0, 0, 4, 0, 0 },
                { 6, 0, 0, 0, 5, 3, 8, 0, 0 },
                { 0, 0, 0, 2, 0, 0, 0, 0, 3 },
                { 0, 0, 0, 0, 9, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 0, 0, 0, 4, 0 },
                { 0, 0, 4, 0, 8, 5, 0, 0, 1 },
                { 0, 0, 2, 0, 4, 1, 0, 0, 8 },
                { 0, 7, 0, 0, 0, 0, 6, 0, 0 },
                { 0, 0, 0, 3, 0, 0, 0, 0, 0 }
        };
        boards.add(board1);

        int[][] board2 = {
                { 9, 2, 0, 0, 0, 0, 0, 0, 5 },
                { 0, 0, 3, 0, 7, 8, 4, 0, 0 },
                { 0, 0, 0, 6, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 9, 0, 0 },
                { 0, 0, 6, 4, 0, 0, 0, 0, 0 },
                { 0, 3, 0, 0, 9, 6, 0, 2, 0 },
                { 7, 0, 0, 0, 0, 0, 0, 4, 0 },
                { 0, 0, 8, 0, 3, 9, 7, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0 }
        };
        boards.add(board2);

        int[][] board3 = {
                { 0, 3, 0, 7, 0, 0, 0, 0, 0 },
                { 0, 0, 2, 0, 0, 0, 6, 0, 0 },
                { 8, 0, 0, 0, 1, 3, 0, 0, 5 },
                { 0, 6, 0, 0, 7, 4, 5, 0, 0 },
                { 4, 0, 0, 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 8, 0, 0, 0, 0, 7 },
                { 0, 0, 0, 0, 0, 9, 0, 0, 0 },
                { 3, 0, 0, 0, 4, 5, 0, 0, 1 },
                { 0, 8, 0, 0, 0, 0, 0, 3, 0 }
        };
        boards.add(board3);

        int[][] board4 = {
                { 0, 8, 0, 6, 0, 0, 0, 9, 0 },
                { 0, 0, 1, 5, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 1, 9, 0, 0, 3 },
                { 0, 4, 0, 0, 0, 0, 0, 0, 2 },
                { 0, 0, 0, 9, 0, 0, 0, 0, 0 },
                { 0, 0, 6, 0, 7, 8, 0, 3, 0 },
                { 0, 0, 7, 0, 3, 1, 0, 8, 0 },
                { 6, 0, 0, 0, 0, 0, 7, 0, 0 },
                { 0, 0, 0, 0, 5, 0, 0, 0, 0 }
        };
        boards.add(board4);

        int[][] board5 = {
                { 1, 4, 0, 6, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 8 },
                { 0, 0, 3, 0, 0, 7, 9, 4, 0 },
                { 0, 6, 0, 7, 0, 0, 2, 8, 0 },
                { 0, 0, 2, 0, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 0, 0, 8, 0, 0, 3 },
                { 0, 0, 9, 0, 0, 4, 7, 2, 0 },
                { 0, 3, 0, 0, 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 5, 0, 0 }
        };
        boards.add(board5);

        // Print the boards
        for (int i = 0; i < boards.size(); i++) {
            System.out.println("\nBoard " + (i + 1) + ":");
            SS.startGame(boards.get(i));
            // for (int j = 0; j < 9; j++) {
            //     for (int k = 0; k < 9; k++) {
            //         System.out.print(boards.get(i)[j][k] + " ");
            //     }
            //     System.out.println();
            // }
            System.out.println();
        }

        displayAverage(SS.totalTime);
    }

    public static void displayAverage(long TT) {
        System.out.println("Average time is " + (TT/1000.0)/5);
    }
}