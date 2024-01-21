package Divide_Conquer;

public class Search_Rotated_Sorted {

    //TC - O(nlogn)
    public static int rotatedSortedSearch(int[] arr, int si, int ei, int tar){
        if(si > ei){
            return -1;
        }

        int mid = si + (ei - si)/2;

        if(tar == arr[mid]){
            return mid;
        }

        //for left
        if(arr[mid] >= arr[si]){
            if(tar >= arr[si] && tar <= arr[mid]){
                return rotatedSortedSearch(arr, si, mid - 1, tar);
            } else {
                return rotatedSortedSearch(arr, mid + 1, ei, tar);
            }
        }

        //for right
        else {
            if(arr[mid] <= tar && tar <= arr[ei]){
                return rotatedSortedSearch(arr, mid + 1, ei, tar);
            } else {
                return rotatedSortedSearch(arr, si, mid - 1, tar);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 0, 1, 2};

        int target = 6;

        System.out.println(rotatedSortedSearch(arr, 0, arr.length - 1, target));
    }
}
