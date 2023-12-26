package Arrays_2D;

import java.util.Scanner;

public class TwoDArr_Operations {

    static int sum = 0;

    public static void diagonalSum(int[][] arr){ //TC -O(N^2)
        sum = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(i == j || i + j == arr.length - 1){
                    sum += arr[i][j];
                    // System.out.println(arr[i][j] + "=" + sum);
                }
            }
        }

        // return sum;
        System.out.println("Sum = " + sum);
    }

    public static void diagonalSumOp(int[][] arr){
        sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i][i];

            if(i != arr.length - 1 - i){ // condition so that primary matrix element doesn't get repeated
                sum += arr[i][arr.length - 1 - i];
            }
        }

        System.out.println("Sum = " + sum);
    }

    public static boolean searchSortedMatrix(int[][] arr, int target){ // TC - O(M + N)
        int row = 0, col = arr[0].length - 1;
        while(row <= arr.length - 1 && col >= 0){
            if(arr[row][col] == target){
                System.out.println("Key found at index : (" + row + "," + col + ")");
                return true;
            } else if(arr[row][col] > target){
                col--;
            } else {
                row++;
            }
        }

        System.out.println("Key not found!");
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{10, 20 ,30, 40, 50},
                        {15, 25, 35, 45, 55},
                        {27, 29, 37, 48, 61},
                        {32, 33, 39, 54, 65},
                        {34, 36, 41, 58, 67}};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the operation : \n 1. Diagonal Sum - O(N^2)\n 2. Diagonal Sum - O(N^2)\n 3. Search in Sorted Matrix - O(M + N)\n:");
        int choice = sc.nextInt();
        // System.out.println(diagonalSum(arr));
        switch (choice) {
            case 1:
                System.out.println("Finding Diagonal Sum with TC - O(N^2)");
                diagonalSum(arr);
                break;
            case 2:
            System.out.println("Finding Diagonal Sum with TC - O(N)");
                diagonalSumOp(arr);
                break;
            case 3:
                System.out.print("Enter the target :");
                int target = sc.nextInt();
                searchSortedMatrix(arr, target);
            default:
                break;
        }
    }
}
