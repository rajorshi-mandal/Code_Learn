package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Algorithms {

    public static void bubbleSort(int[] arr) { // TC - O(N^2)
        for (int i = 0; i < arr.length - 2; i++) { // total number of iteration s fro swap
            for (int j = 0; j < arr.length - i - 1; j++) { // totatl number of swap for each iteration
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) { // TC - O(N^2)
        for (int i = 0; i < arr.length; i++) { // Total iterations for all elements
            int minPos = i; // finding min element index
            for (int j = i + 1; j < arr.length; j++) { // loop goes for checking all elements after assigning the minPos
                if (arr[minPos] > arr[j]) {
                    minPos = j; // updatnig minposition based on satisfied condition
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void countingSort(int[] arr) {
        // applicable for smaller arrays

        // find largest element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Math.max(largest, arr[i]);
        }

        int[] count = new int[largest + 1];
        // storing frequency fo elements
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void insertionSort(int[] arr) { // TC - O(N^2)
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i]; // storing the current element value to adjust at last
            int prev = i - 1; // iterator for checking all elements if greater than the current element

            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev]; // shifting the grater element to right by just copying to next index
                prev--;
            }
            arr[prev + 1] = curr; // prev + 1 since it might become -1 too
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 1, 2, 5, 3, 7};

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Enter the Sorting Algorithm to use \n 1. Bubble Sort - O(N^2) \n 2. Selection Sort - O(N^2)\n 3. Insertion Sort - O(N^2)\n 4.Inbuilt Sort - O(NlogN)\n 5.Counting Sort (duplicate elements) - O(N + range)\n 0. to exit\n:");

        int choice = sc.nextInt();

        switch (choice) {
            case 0:
                break;
            case 1:
                System.out.println("Performing Bubble Sort :");
                bubbleSort(arr);
                printArr(arr);
                break;
            case 2:
                System.out.println("Performing Selection Sort :");
                selectionSort(arr);
                printArr(arr);
                break;
            case 3:
                System.out.println("Performing Insertion Sort :");
                insertionSort(arr);
                printArr(arr);
                break;
            case 4:
                System.out.println("Performing Counting Sort :");
                countingSort(arr);
                printArr(arr);
                break;
            default:
                System.out.println("Performing Inbuilt sort :");
                Arrays.sort(arr);
                printArr(arr);
        }
        // printArr(arr);
    }
}
