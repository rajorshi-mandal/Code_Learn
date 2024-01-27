package Backtracking.self;

import java.util.ArrayList;

public class Permutations_int_2 {

    public static void permutationsII(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> tempList, int[] nums, boolean[] used){
        //unique permutation
        //base case : check if permutation is received and also check that the permutation is already in result or not
        if(tempList.size() == nums.length && !resultList.contains(tempList)){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            //check if the element at idx is already used ; skip for true
            if(used[i]) {
                continue;
            }

            //else
            used[i] = true;
            tempList.add(nums[i]);

            permutationsII(resultList, tempList, nums, used);

            //after that element is used remove it and set it as unused for next iteration
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void printArrayList(ArrayList<ArrayList<Integer>> resultList){
        for(ArrayList<Integer> item : resultList){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        ArrayList<Integer> tempList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        permutationsII(resultList, tempList, nums, used);
        printArrayList(resultList);
    }
}
