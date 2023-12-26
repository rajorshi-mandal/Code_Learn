package Arrays;

public class kadane_algorithm {

    public static int kadane(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i < arr.length; i++){
            currSum += arr[i];

            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 6, -1, 3};
        int minNeg = Integer.MIN_VALUE;
        //kadane's alogrithm fails if all numbers are negative
        //function for all negative numbers if not then call kadanes\

        boolean flag = true;
        for(int i = 0; i < arr.length; i++){
            if(minNeg < arr[i]){
                minNeg = arr[i];
            }

            if(arr[i] >= 0){
                System.out.println(kadane(arr));
                flag = false;
                break;
            }

            if(!flag){
                System.out.println(minNeg);
            }
        }
    }
}
