package Recursion;

public class recursion {

    public static void printNOne(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }

        System.out.print(n + " ");
        printNOne(n - 1);
    }

    public static int factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        }

        int ans =  n * factorial(n - 1);
        return ans;
    }

    public static int sumN(int n){
        if(n == 1){
            return 1;
        }

        int sum = n + sumN(n - 1);
        return sum;
    }

    public static int nthFibonacci(int n){ //TC - O(2^n) and SC - O(n)
        if(n == 1 || n == 0){
            return n;
        }

        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    public static boolean isSorted(int[] arr, int i){

        if(i == arr.length - 1){
            return true;
        }

        if(arr[i] > arr[i + 1]){
            return false;
        }

        return isSorted(arr, i + 1);
    }

    public static int firstOcc(int[] arr, int key, int i){
        if(i == arr.length - 1){
            return -1;
        }

        if(arr[i] == key){
            return i;
        }

        return firstOcc(arr, key, i + 1);
    }

    public static int lastOcc(int[] arr, int key, int i){
        if(i == arr.length - 1){
            return -1;
        }

        int lastOcc = lastOcc(arr, key, i + 1);
        if(lastOcc != -1 && arr[i] == key){
            return i;
        }

        return lastOcc;
    }

    public static int powX(int x, int n){ //Tc - O(n)
        if(n == 1){
            return x;
        }

        return x * powX(x, n - 1);
    }

    public static int powXlogn(int x, int n){
        if(n == 1){
            return x;
        }

        int product =  powXlogn(x, n / 2) * powXlogn(x, n / 2);

        if(n % 2 != 0){
            product *= x;
        }

        return product;
    }
    
    public static int tilling(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return tilling(n - 1) + tilling(n - 2);
    }

    public static void main(String[] args) {
        // printNOne(10);
        // System.out.println(factorial(4));
        // System.out.println(sumN(5));
        // System.out.println(nthFibonacci(4));

        int[] arr = {1, 2, 2, 3, 4, 9 , 7, 8, 4, 6};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOcc(arr, 7, 0));
        // System.out.println(powX(2, 3));
        // System.out.println(powXlogn(3, 3));
        System.out.println(tilling(5));
    }
}
