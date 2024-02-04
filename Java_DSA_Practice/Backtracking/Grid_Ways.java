package Backtracking;

public class Grid_Ways {

    public static int gridWays(int i, int j, int n, int m){ //O(2^(n + m))
        if(i == n - 1 && j == m - 1){ //reached target cell
            return 1;
        }else if (i == n || j == n){    //reached end of row or end of cell
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);

        return w1 + w2;
    }

    public static int gridWaysPermute(int m, int n){
        return factorial(n - 1 + m - 1)/ ((factorial(n - 1) * factorial(m - 1)));
    }

    public static int factorial(int num){
        if(num == 0 || num == 1){
            return 1;
        }

        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(gridWaysPermute(3, 3));
    }
}
