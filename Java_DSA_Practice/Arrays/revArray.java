package Arrays;

public class revArray {

    public static void revArr(int[] arr){
        int l = arr.length;

        for(int i = 0; i < l / 2; i++){
            //swap -> method 1
            // int temp = arr[l - i - 1];
            // arr[l - i - 1] = arr[i];
            // arr[i] = temp;

            //swap - method 2
            arr[i] = arr[i] + arr[l - i - 1]; //A = A + B
            arr[l - i - 1] = arr[i] - arr[l - i - 1]; //B = A - B
            arr[i] = arr[i] - arr[l - i - 1]; //A = A - B
        }

        //using while 
        //first = 0, last = arr.legnth - 1
        //while(first < last){}
    }

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // int[] arr = {1, 2, 3, 4};

        revArr(arr);
        printArr(arr);
    }
}
