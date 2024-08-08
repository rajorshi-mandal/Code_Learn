package Array_part_2.HW;

public class Element_Twice_In_Array {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(elementAtleastTwice(arr));
    }

    public static boolean elementAtleastTwice(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j =  i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
