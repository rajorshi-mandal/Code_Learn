package Backtracking;

import java.util.ArrayList;

public class Rat_in_Maze_Int {

    public static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
    }

    public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol, ArrayList<String> paths) {

        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            printMaze(sol);
            // storeMaze(sol, paths);
            return false;
        }

        if (isSafe(maze, x, y)) {
            if (sol[x][y] == 1) {
                return false;
            }

            sol[x][y] = 1;
            if (solveMazeUtil(maze, x + 1, y, sol, paths)) {
                return true;
            }

            if (solveMazeUtil(maze, x, y + 1, sol, paths)) {
                return true;
            }

            sol[x][y] = 0;
        }

        return false;
    }

    public static void solveMaze(int[][] maze) {
        int[][] sol = new int[maze.length][maze[0].length];
        ArrayList<String> paths = new ArrayList<>();

        if (!solveMazeUtil(maze, 0, 0, sol, paths)) {
            System.out.println("No more Solutions ");
        }
        // solveMazeUtil(maze, 0, 0, sol, paths);

        // for(int i = 0; i < paths.size(); i++){
        //     System.out.print(paths.get(i) + " ");
        // }
        // System.out.println();
    }

    public static void printMaze(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
        System.err.println();
    }

    public static void storeMaze(int[][] sol, ArrayList<String> paths){

        StringBuilder path = new StringBuilder("");

        int prev_i = 0, prev_j = 0;
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                if(sol[i][j] == 1){
                    if(i > prev_i && j == prev_j){
                        prev_i = i;
                        prev_j = j;
                        path.append('D');
                    } else if(i == prev_i && j > prev_j){
                        prev_i = i;
                        prev_j = j;
                        path.append('R');
                    } else if(i < prev_i && j == prev_j){
                        prev_i = i;
                        prev_j = j;
                        path.append('U');
                    } else if(i == prev_i && j < prev_j){
                        prev_i = i;
                        prev_j = j;
                        path.append('L');
                    }
                }
            }
        }

        paths.add(path.toString());
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        solveMaze(maze);
    }
}
