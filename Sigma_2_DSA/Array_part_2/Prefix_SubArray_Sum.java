package Array_part_2;

public class Prefix_SubArray_Sum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 6, -1, 3};
        prefixSubarraySum(arr);
    }

    public static void prefixSubarraySum(int[] arr) { //TC - O(n^2)
        int tsa = 0;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        int[] prefix = new int[arr.length];

        //calcualte prefix array
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) { //not i + 1 becuase we need single element array as well
                int end = j;
                tsa++;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if(max < currSum) {
                    max = currSum;
                }
            }
        }
        // System.out.println();
        System.out.println("Total Sub Arrays : " + tsa + ", max subarray sum: " + max );
    }
}
