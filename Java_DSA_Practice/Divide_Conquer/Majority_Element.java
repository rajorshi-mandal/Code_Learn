package Divide_Conquer;

public class Majority_Element {

    //Brute Force - O(n^2)
    public static int majorityElement(int[] arr){
        int majorityCount = arr.length / 2;

        for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            if(count > majorityCount){
                return arr[i];
            }
        }

        return -1;
    } 

    public static int countInRange(int[] arr,int si, int ei, int element){
        int count = 0;

        for (int i = si; i <= ei; i++) {
            if (arr[i] == element) {
                count++;
            }
        }

        return count;
    }

    public static int majorityElementOp(int[] arr, int lo, int hi){
        if(lo == hi){ //for only 1 element
            return arr[lo];
        }

        int mid = lo + (hi - lo)/2;

        //recursive on left and right
        int left = majorityElementOp(arr, lo, mid);
        int right = majorityElementOp(arr, mid + 1, hi);

        //if both have agree in the majority element
        if(left == right){
            return left;
        }

        int leftCount = countInRange(arr, lo, hi, left);
        int rightCount = countInRange(arr, lo, hi, right);

        return leftCount > rightCount ? left : right;
    }

    public static int majorityElementMVA(int[] arr){ //Moore's voting algorithm
        int ansIndex = 0;
        int count = 1;

        for(int i = 1;i < arr.length; i++){
            if(arr[i] == arr[ansIndex]){
                count++;
            } else {
                count--;
            }

            if(count == 0){
                ansIndex = i;
                count = 1;
            }
        }

        int fCount = 0;
        for(int i = 0; i < arr.length; i++){
            //loop for majority element confirmation
            if(arr[i] == arr[ansIndex]){
                fCount++;
            }
        }   
        if(fCount > arr.length/2){
            return arr[ansIndex];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 1, 1, 2, 1};

        // System.out.println(majorityElement(arr));
        // System.out.println(majorityElementOp(arr, 0, arr.length - 1));
        System.out.println(majorityElementMVA(arr));
    }
}
