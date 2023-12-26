package Arrays;

public class Binary_Search {

    public static int binarySearch(int[] arr, int key){
        int l = 0, r = arr.length - 1;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(arr[mid] == key){
                return mid;
            } else if(arr[mid] < key){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 10, 12, 14, 16 ,18};
        System.out.println(binarySearch(arr, 14));
    }
}
