package Backtracking.self;

import java.util.ArrayList;

public class Permutations_int {

    public static void permutations(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> tempList, int[] nums){

        //base case : add in result when one permutation received
        if(tempList.size() == nums.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int number : nums){
            //skip same number choice 
            if(tempList.contains(number)){
                continue;
            }

            tempList.add(number);
            permutations(resultList, tempList, nums);

            //remove previous element after adding in result
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

        permutations(resultList, tempList, nums);
        printArrayList(resultList);
    }
}
