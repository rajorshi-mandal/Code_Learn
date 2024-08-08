package Array_part_2.HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Triplet_Sum_Zero {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, 4};
        List<List<Integer>> res = tripletZeroSum(arr);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }

    public static List<List<Integer>> tripletZeroSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(arr[i]);
                        triplet.add(arr[j]);
                        triplet.add(arr[k]);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                }
            }
        }

        res = new ArrayList<List<Integer>> (new LinkedHashSet<List<Integer>> (res));
        return res;
    }
}
