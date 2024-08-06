package Array;

public class Largest_Smallest_Number {
    public static void main(String[] args) {
        int[] arr = {23, 45, 67, 12, 89, 34, 56, 78, 90, 11};
        largestSmallestNumber(arr);
    }

    public static void largestSmallestNumber(int[] arr) {
        int largest = Integer.MIN_VALUE; // -infinity
        int smallest = Integer.MAX_VALUE; // +inifinty
        for (int i = 0; i < arr.length; i++) {
            if(largest < arr[i]) {
                largest = arr[i];
            }
            if(smallest > arr[i]) {
                smallest = arr[i];
            }
        }

        System.out.println("The largest element in the array : " + largest);
        System.out.println("The smallest element in the array : " + smallest);
    }
}
