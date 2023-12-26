package Arrays;

public class Trapping_Rainwwater {

    public static int trappingRainwater(int[] height){
        //left Max Boundary array
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //right max boundar yarray
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int trappedWater = 0;

        for(int i = 0;i < height.length; i++){
            //water level = min of left max boudary and right max boundary
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            //trappedRainwater = waterLevel - height of the pillar
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 6, 3, 2, 5};

        System.out.println(trappingRainwater(height));
    }
}
