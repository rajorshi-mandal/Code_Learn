package Conditional_Statements.HW;

import java.util.Scanner;

public class Week_Day {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter week day number : ");
        int weekDay = sc.nextInt();

        switch (weekDay) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
            System.out.println("Invalid Input1 -> Please enter the week number between 1-7");
                break;
        }
    }
}
