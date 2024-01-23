package Divide_Conquer;

public class Count_Inversions {

    public static int countInversions(int[] arr){ //TC - O(N ^ 2)
        int count = 0;

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    //swap
                    arr[i] += arr[j]; //A = A + B
                    arr[j] = arr[i] - arr[j]; // B = A - B
                    arr[i] -= arr[j]; // A = A - B

                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static int mergeSort(int[] arr,int si, int ei){
        int invCount = 0;

        if(ei > si){
            int mid = si + (ei - si)/2;

            invCount = mergeSort(arr, ei, mid);
            invCount += mergeSort(arr, mid + 1, ei);
            invCount += merge(arr, si, mid, ei);
        }

        return invCount;
    }

    public static int merge(int[] arr, int si, int mid, int ei){

        int[] temp = new int[ei - si + 1];
        int invCount = 0;

        int i = si; //iterator for left part
        int j = mid; //iterator for right part
        int k = 0; //iterator for temporary array

        while(i < mid && j <= ei){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                invCount += mid - i;
            }
            k++;
        }

        //left part remaining
        while(i < mid){
            temp[k++] = arr[i++];
        }

        //right remaining part
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        //copying the temp array to main arr
        for(k = 0, i = si; k < temp.length; k++,i++){
            arr[i] = temp[k];
        }

        return invCount;
    }

    public static int countInversionOp(int[] arr){
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 1, 5};

        // System.out.println(countInversions(arr));
        System.out.println(countInversionOp(arr));
    }
}
