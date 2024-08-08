package Array_part_2;

public class Max_SubArraySum_Kadane_Algo {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        kadanes(arr);
    }

    public static void kadanes(int[] arr) { //TC - O(n)
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            if(cs < 0) {
                cs = 0;
            }
            if(ms < cs) {
                ms = cs;
            }
        }

        System.out.println("The Max SubArray Sum : " + ms);
    }
}
