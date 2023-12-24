package Arrays;

public class Prefix_array_maxSubarraySum {

    public static int prefixMaxSubArrSum(int[] parr){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i < parr.length; i++){
            for(int j = i; j < parr.length; j++){
                currSum = i == 0 ? parr[j] : parr[j] - parr[i - 1];
            }
            if(maxSum < currSum){
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 6, -1, 3};

        //find prefix array first
        int[] parr = new int[arr.length];

        parr[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            parr[i] = parr[i - 1] + arr[i];
        }

        System.out.println(prefixMaxSubArrSum(parr));
    }
}
