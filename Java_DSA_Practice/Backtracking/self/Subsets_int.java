package Backtracking.self;

import java.util.ArrayList;

public class Subsets_int {

    //self
    public static void subsetsInt(ArrayList<Integer> list, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> subset, int i){
        if(i == list.size()){
            subset.add(new ArrayList<>(temp));
            return;
        }

        //included
        temp.add(list.get(i));
        subsetsInt(list, temp, subset, i + 1);
        
        //excluded
        temp.remove(temp.size() - 1);
        subsetsInt(list, temp, subset, i + 1);
    }

    public static void printFinal(ArrayList<ArrayList<Integer>> subset){
        for (ArrayList<Integer> sub : subset) {
            System.out.print(sub + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> subset = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        subsetsInt(list, temp, subset, 0);
        printFinal(subset);
    }
}
