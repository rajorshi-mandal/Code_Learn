package Backtracking;

import Packages.ArrayPrinter;

public class Change_Arr {
    
    private static ArrayPrinter parr = new ArrayPrinter();

    public static void changeArr(int[] arr, int i, int val){
        
        if(i == arr.length){
            parr.printArray(arr);
            return;
        }

        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] -= 2;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        changeArr(arr, 0, 1);
        parr.printArray(arr);
    }
}
