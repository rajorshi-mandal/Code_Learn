package Array_Part_1.HW_Video;

public class Subarray_Sum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printSubarrays(arr);
    }

    public static void printSubarrays(int[] arr) {
        int tsa = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        System.out.println("{Sub Array, Sum} :- ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) { //not i + 1 becuase we need single element array as well
                tsa++;
                int sum = 0;
                System.out.print("{[");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                    sum += arr[k];
                }
                //update max sub array sum
                if(max < sum) {
                    max = sum;
                }
                //update smallest sub array sum
                if(min > sum) {
                    min = sum;
                }
                System.out.print("], " + sum + "} ");
            }
            System.out.println();
        }
        // System.out.println();
        System.out.println("Total Sub Arrays : " + tsa + ", max and min sub array sum : (" + max + ", " + min +")");
    }
}
