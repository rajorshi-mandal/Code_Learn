package Functions_Methods.HW;

import java.util.Scanner;

public class Check_Even {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();

        if(isEven(n)) {
            System.err.println("Even");
        } else {
            System.out.println("Not Even");
        }
    }

    public static boolean isEven(int n) {
        if(n % 2 == 0) {
            return true;
        }
        return false;
    }
}
