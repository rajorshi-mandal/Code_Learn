package Array;

public class Linear_Search {
    public static void main(String[] args) {
        int[] numbers = {2,4,6,8,10,12,14,16};
        String[] eveningSnacks = {"Banana", "Tea", "Samosa", "Chips"};
        int key = 10;
        String food = "Samosa";

        System.out.println("The key is at index : " + linearSearch(numbers,key));
        System.out.println("The evening snack is available at counter : " + linearSearch(eveningSnacks, food));
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if(key == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if(key.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
}
