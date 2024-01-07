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

    //iterative approach
    // public static String removeDup(String str){
    //     StringBuilder sb = new StringBuilder("");

    //     int[] arr = new int[26];

    //     for(int i = 0; i < str.length(); i++){
    //         char ch = str.charAt(i);
    //         if(arr[ch - 'a'] == 0){
    //             arr[ch - 'a']++;
    //             sb.append(ch);
    //         } else {
    //             arr[ch - 'a']++;
    //         }
    //     }

    //     return sb.toString();
    // }

    public static String removeDup(String str, int i, StringBuilder newStr, boolean[] map){

        if(i == str.length()){
            // System.out.println(newStr);
            return newStr.toString();
        }

        char ch = str.charAt(i);
        if(map[ch - 'a'] == true){
            removeDup(str, i + 1, newStr, map);
        } else {
            newStr.append(ch);
            map[ch - 'a'] = true;
            removeDup(str, i, newStr, map);
        }

        return newStr.toString();
    }

    public static int friendsPair(int n){
        if(n == 1 || n == 2){
            return n;
        }

        return friendsPair(n - 1) + (n - 1) * friendsPair(n - 2);
    }

    public static void printBinIntStrings(int n, String str, int lastPlace){
        if(n == 0){
            System.out.println(str);
            return;
        }

        printBinIntStrings(n - 1,str + "0", 0);
        if(lastPlace == 0){
            printBinIntStrings(n - 1, str + "1", 1);
        }
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n == 0){
            return;
        }

        towerOfHanoi(n - 1, src, dest, helper);
        System.out.println("move " + src + " to " + dest);
        towerOfHanoi(n - 1, helper, src, dest);
    }


    public static int countSubStringsFirstEndSame(String str, int i, int j, int n){
        if(n == 1){
            return 1;
        }

        if(n <= 0){
            return 0;
        }

        int count = countSubStringsFirstEndSame(str, i + 1, j, n - 1) + countSubStringsFirstEndSame(str, i, j - 1, n - 1) - countSubStringsFirstEndSame(str, i + 1, j - 1, n - 2);
        if(str.charAt(i) == str.charAt(j)){
            count++;
        }

        return count;
    }

    public static void convertIntToString(int n, String[] arr){
        if(n == 0){
            return;
        }

        convertIntToString(n / 10, arr);
        System.out.print(arr[n % 10]);
    }

    public static int stringLength(String str){
        if(str.length() == 0){
            return 0;
        }

        return stringLength(str.substring(1)) + 1;
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
        // System.out.println(tilling(5));
        StringBuilder sb = new StringBuilder("");
        boolean[] map = new boolean[26];
        // System.out.println(removeDup("appnnacollegge",0,sb, map));

        // System.out.println(friendsPair(4));
        // printBinIntStrings(3, "", 0);
        // towerOfHanoi(3, "A", "B", "C");
        String str = "abcab";
        // System.out.println(countSubStringsFirstEndSame(str, 0, str.length() - 1, str.length()));

        String[] numberStrings = {
            "Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"
        };

        // convertIntToString(174, numberStrings);
        System.out.println(stringLength("rcciit"));
    }
}
