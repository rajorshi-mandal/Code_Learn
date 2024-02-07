package Backtracking;

public class Knights_Tour {

    public static boolean isSafe(int x, int y, int[][] sol, int N){
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    public static boolean solveKTUtil(int x, int y, int movei, int[][] sol, int[] x_move, int[] y_move, int N){

        if(movei == N * N){
            return true;
        }

        for(int i = 0; i < 8; i++){
            int next_x = x + x_move[i];
            int next_y = y + y_move[i];
            if(isSafe(next_x, next_y ,sol, N)){
                sol[next_x][next_y] = movei;
                if(solveKTUtil(next_x, next_y, movei + 1, sol, x_move, y_move, N)){
                    return true;
                } else {
                    sol[next_x][next_y] = -1;
                }
            } 
        }

        return false;
    }

    public static void printSolution(int[][] sol){
        for(int i = 0; i < sol.length; i++){
            for(int j = 0; j < sol.length; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveKT(int N){
        int[][] sol = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sol[i][j] = -1;
            }
        }

        int[] x_move = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] y_move = {1, 2, 2, 1, -1, -2, -2, -1};

        //knight starts from cell 0,0
        sol[0][0] = 0;
        if(!solveKTUtil(0, 0, 1, sol, x_move, y_move, N)){
            System.out.println("No solution");
        } else {
            printSolution(sol);
        }
    }

    public static void main(String[] args) {
        solveKT(5);
    }
}
