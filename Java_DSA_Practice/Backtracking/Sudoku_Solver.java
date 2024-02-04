package Backtracking;

public class Sudoku_Solver {

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit){
        //column
        for(int i =0; i <= 8; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        //row
        for(int j = 0; j <= 8; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        //grid

        //starting row of the small board (staring index)
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        //3 * 3
        for(int r = sr; r < sr + 3; r++){
            for(int c = sc; c < sc + 3; c++){
                if(sudoku[r][c] == digit){
                    return false;
                }
            }
        }
        

        return true;
    }

    public static boolean sudokuSolver(int[][] sudoku, int row, int col){
        if(row == 9){
            return true;
        }

        //incrementing row and column
        int nextRow = row, nextCol = col + 1;
        if(col + 1 == 9){
            nextRow = row  + 1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){ // if element other than 0 already exists
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        //placing digits
        for(int digit = 1; digit <= 9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit; //place number if true
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    //solution exists
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printBoard(int[][] sudoku){
        for(int i = 0; i < sudoku.length; i++){
            for(int j = 0; j < sudoku[0].length; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution exists !!");
            printBoard(sudoku);
        } else {
            System.out.println("Solution doesn't exists !!");
        }
    }
}
