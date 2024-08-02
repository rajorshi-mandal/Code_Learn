package Functions_Methods.HW;

import java.util.Scanner;

public class Sum_Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        System.out.println("Sum of digits for integer : " + n + " is " + sumDigits(n));
    }

    public static int sumDigits(int n) {
        int sum = 0;

        for(int i = n; i > 0; i /= 10) {
            sum += i % 10;
        }

        return sum;
    }
}

