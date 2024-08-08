package Array_part_2.HW;

public class Search_Rotated_Sorted_Array_At_Pivot {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7, 0, 1};
        int target = 1;
        System.out.println(searchSub(arr, target));
    }

    public static int searchSub(int[] arr, int target) {
        int min = minSearch(arr);

        if(target >= arr[min] && target <= arr[arr.length - 1]) {
            return binarySearch(arr, target, min, arr.length - 1);
        } else {
            return binarySearch(arr, target, 0, min - 1);
        }
    }

    public static int minSearch(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int m = l + (r - l)/2;

            if(m > 0 && arr[m - 1] > arr[m]) {
                return m;
            } else if(arr[l] <= arr[m] && arr[m] > arr[r]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public static int binarySearch(int[] arr, int target, int l, int r) {
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
