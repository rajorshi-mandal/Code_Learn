package Array;

public class Binary_Search {
    public static void main(String[] args) {
        int[] sortedArray = {3, 9, 15, 20, 26, 32, 38, 42, 50, 56};
        int target = 42;

        System.out.println("The target is at index : " + binarySearch(sortedArray, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(target == arr[mid]) {
                return mid;
            } else if(target > arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
