package Divide_Conquer;

public class Quick_Sort {

    public static int pivot(int[] arr, int l, int h){
        int pivot = arr[h];
        int i = l - 1;

        for(int j = l; j < h; j++){
            if(arr[j] < pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp  = arr[i];
        arr[i] = pivot;
        arr[h] = temp;
        return i;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pIdx = pivot(arr, low, high);

            quickSort(arr, low, pIdx-1);
            quickSort(arr, pIdx + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 0, 2, 3, 9};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        //print
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }System.out.println();
    }
}
