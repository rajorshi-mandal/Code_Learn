package Array;

public class Reverse_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // reverseArray(arr);
        selfReverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selfReverseArray(int[] arr) {
        int size = arr.length - 1;
        for (int i = 0; i <= size/2; i++) {
            //self 1
            // arr[i] += arr[size - i];
            // arr[size - i] = arr[i] - arr[size - i];
            // arr[i] -= arr[size - i];

            //self 2
            arr[i] ^= arr[size - i];
            arr[size - i] ^= arr[i];
            arr[i] ^= arr[size - i];
        }
    }

    public static void reverseArray(int[] arr) {
        int first = 0, last = arr.length - 1;

        while (first < last) {
            //swap
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;

            first++;
            last--;
        }
    }
}
