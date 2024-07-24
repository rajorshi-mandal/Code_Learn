package Conditional_Statements;
import java.util.*;

public class Income_Tax_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int income = sc.nextInt();

        if(income <= 500000) {
            System.out.println("Tax 0% = 0");
        } else if(income > 500000 && income < 1000000) {
            System.out.println("Tax 20% = " + (int)(income * 0.2));
        } else {
            System.out.println("Tax 30% = " + (int)(income * 0.3));
        }
    }
}
