package Backtracking.self;

import java.util.ArrayList;

public class Rat_in_Maze_String {

    public static void solveMazeUtil(int i, int j, int[][] maze, int n, StringBuilder path, ArrayList<String> paths, boolean[][] vis){

        if(i == n - 1 && j == n - 1){
            paths.add(path.toString());
            return;
        }

        //downward
        if(i + 1 < n && maze[i + 1][j] == 1 && !vis[i + 1][j]){
            vis[i][j] = true;
            solveMazeUtil(i + 1, j, maze, n, path.append('D'), paths, vis);
            vis[i][j] = false;
            path.deleteCharAt(path.length() - 1);  // Backtrack
        }

        //left
        if(j - 1 >= 0 && maze[i][j - 1] == 1 && !vis[i][j - 1]){
            vis[i][j] = true;
            solveMazeUtil(i, j - 1, maze, n, path.append('L'), paths, vis);
            vis[i][j] = false;
            path.deleteCharAt(path.length() - 1);  // Backtrack
        }

        //right
        if(j + 1 < n && maze[i][j + 1] == 1 && !vis[i][j + 1]){
            vis[i][j] = true;
            solveMazeUtil(i, j + 1, maze, n, path.append('R'), paths, vis);
            vis[i][j] = false;
            path.deleteCharAt(path.length() - 1);  // Backtrack
        }

        //up
        if(i - 1 >= 0 && maze[i - 1][j] == 1 && !vis[i - 1][j]){
            vis[i][j] = true;
            solveMazeUtil(i - 1, j, maze, n, path.append('U'), paths, vis);
            vis[i][j] = false;
            path.deleteCharAt(path.length() - 1);  // Backtrack
        }
    }

    public static void solveMaze(int[][] maze, int n){
        ArrayList<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        boolean[][] vis = new boolean[n][n];

        if(maze[0][0] == 1){
            solveMazeUtil(0, 0, maze, n, path, paths, vis);
        }
        if(paths.size() == 0){
            System.out.println(-1);
        } else {
            printMazePath(paths, n);
        }
    }

    public static void printMazePath(ArrayList<String> paths, int n){
        for(int i = 0; i < paths.size(); i++){
            System.out.print(paths.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        solveMaze(maze, maze.length);
    }
}
