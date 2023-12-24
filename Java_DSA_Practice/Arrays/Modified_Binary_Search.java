package Arrays;

public class Modified_Binary_Search {

    public static int findMin(int[] nums){
        int l = 0,r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l)/2;

            if(mid > 0 && nums[mid - 1] > nums[mid]){
                return mid;
            } else if(nums[l] <= nums[mid] && nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    public static int search(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static int findRegion(int[] nums, int target){
        int minIdx = findMin(nums);

        if(nums[minIdx] <= target && target <= nums[nums.length - 1]){
            return search(nums, minIdx + 1, nums.length - 1, target);
        } else {
            return search(nums, 0, minIdx, target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(findRegion(nums, 1));
    }
}
