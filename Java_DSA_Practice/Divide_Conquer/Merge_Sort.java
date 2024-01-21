package Divide_Conquer;

public class Merge_Sort {

    public static void mergeSort(int[] arr ,int i ,int j){
        if(i >= j){
            return;
        }

        int mid = (i + (j - i)/2);

        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        merge(arr, i, j, mid);
    }

    public static void merge(int[] arr, int i, int j, int m){
        int[] temp = new int[j - i + 1];

        int si = i;
        int ei = m + 1;
        int ti = 0;

        while(si <= m && ei <= j){ //compare and put the smaller in temp
            if(arr[si] < arr[ei]){
                temp[ti] = arr[si]; 
                si++;
            } else {
                temp[ti] = arr[ei];
                ei++;
            }
            ti++;
        }

        while(si <= m){ //copy the leftover to temp
            temp[ti++] = arr[si++];
        }

        while(ei <= j){ //copy the leftovewr to temp
            temp[ti++] = arr[ei++];
        }

        //copy the temp array to main array
        for(ti = 0, si = i; ti < temp.length; ti++,si++){
            arr[si] = temp[ti];
        }
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 9, 3, 1, 0, 6};

        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
