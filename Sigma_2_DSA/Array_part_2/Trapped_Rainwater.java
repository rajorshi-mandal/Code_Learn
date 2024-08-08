package Array_part_2;

public class Trapped_Rainwater {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 6, 3, 2, 5};
        if(height.length < 3) {
            System.out.println("Trapped Rainwater : " + 0);
        } else {
            System.out.println("Trapped Rainwater : " + trappedRainwater(height));
        }
    }

    public static int trappedRainwater(int[] height) { //TC - O(n)
        int size = height.length;

        //auxiliary arrays
        int[] lmb = new int[size];
        int[] rmb = new int[size];

        //left max boundary
        lmb[0] = height[0];
        for (int i = 1; i < size; i++) {
            if(height[i] > lmb[i - 1]) {
                lmb[i] = height[i];
            } else {
                lmb[i] = lmb[i - 1];
            }
        }
        // printArr(lmb);

        //right max boundary
        rmb[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            if(height[i] > rmb[i + 1]) {
                rmb[i] = height[i];
            } else {
                rmb[i] = rmb[i + 1];
            }
        }
        // printArr(rmb);

        int tp = 0; //Trapped Rainwater
        for (int i = 0; i < size; i++) {
            int wl = Math.min(lmb[i], rmb[i]); // waterlevel = min(leftmax bound , rightmax bound)
            tp += wl - height[i]; // trapped rainwater = (waterlevel - height of bar) * width of bar [width = 1]
        }

        return tp;
    }

    // public static void printArr(int[] arr) {
        // for (int i = 0; i < arr.length; i++) {
            // System.out.print(arr[i] + " ");
        // }
        // System.out.println( );
    // }
}

