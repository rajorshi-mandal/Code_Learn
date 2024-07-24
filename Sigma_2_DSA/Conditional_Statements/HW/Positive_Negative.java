package Conditional_Statements.HW;

import java.util.Scanner;

public class Positive_Negative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();

        if(number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Postive");
        }
    }
}
