package Conditional_Statements.HW;

import java.util.Scanner;

public class Fever_Checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your temperature: ");
        double temperature = sc.nextDouble();

        if(temperature > 100) {
            System.out.println("You have fever!");
        } else {
            System.out.println("You don't have fever!");
        }
    }
}
