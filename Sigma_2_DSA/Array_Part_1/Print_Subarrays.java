package Array;

public class Print_Subarrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printSubarrays(arr);
    }

    public static void printSubarrays(int[] arr) {
        int tsa = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) { //not i + 1 becuase we need single element array as well
                tsa++;
                System.out.print("[");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                }
                System.out.print("] ");
            }
            System.out.println();
        }
        // System.out.println();
        System.out.println("Total Sub Arrays : " + tsa);
    }
}
