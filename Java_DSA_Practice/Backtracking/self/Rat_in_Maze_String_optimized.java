package Backtracking.self;

import java.util.ArrayList;

public abstract class Rat_in_Maze_String_optimized {

    public static void solveMazeUtil(int i, int j, int[][] maze, int n, ArrayList<String> paths, StringBuilder path, boolean[][] vis, int[] di, int[] dj){

        if(i == n - 1 && j == n - 1) {
            paths.add(path.toString());
            return;
        }

        String dir = "DLRU";
        for(int idx = 0; idx < 4; idx++){
            int next_i = i + di[idx];
            int next_j = j + dj[idx];
            if(next_i >= 0 && next_j >= 0 && next_i < n && next_j < n && maze[next_i][next_j] == 1 && !vis[next_i][next_j]){
                vis[next_i][next_j] = true;
                solveMazeUtil(next_i, next_j, maze, n, paths, path.append(dir.charAt(idx)), vis, di, dj);
                vis[next_i][next_j] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void solveMaze(int[][] maze, int n){
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};

        ArrayList<String> paths = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        if(maze[0][0] == 1){
            solveMazeUtil(0, 0, maze, n, paths, new StringBuilder(""), vis, di, dj);
            if(paths.isEmpty()){
                System.out.println("No Solutions !!");
            } else {
                printMazePath(paths, paths.size());
            }
        } else {
            System.out.println("No Solutions !!");
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
