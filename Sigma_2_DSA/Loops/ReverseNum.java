package Loops;

public class ReverseNum {
    public static void main(String[] args) {
        int n = 10899;

        while(n > 0) {
            System.out.print(n % 10);
            n /= 10;
        }
        System.out.println();
    }
}
