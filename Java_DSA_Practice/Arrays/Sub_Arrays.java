package Arrays;

public class Sub_Arrays {

    public static void printSubArrays(int[] arr) {
        int tsa = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                tsa++;
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr= {2, 4, 6, 8};

        printSubArrays(arr);
    }
}
