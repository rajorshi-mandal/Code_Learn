package Backtracking;

public class N_Queens {

    public static boolean isSafe(char[][] board, int row, int col){
        //vertical
        for(int i = row - 1; i >= 0; i-- ){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diagonal left up
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diagonal right up
        for(int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char[][] board, int row){

        if(row == board.length){
            printBoard(board);
            return;
        }

        for(int j = 0; j < board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }

    public static void printBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //filling with X
        char[][] chessBoard = new char[4][4];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                chessBoard[i][j] = 'X';
            }
        }

        nQueens(chessBoard, 0);
    }
}
