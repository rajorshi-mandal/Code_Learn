package Loops.HW;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int range = sc.nextInt();
        int fact = 1;

        while(range > 0) {
            fact *= range;
            range--;
        }
        System.out.println("Factorial : " + fact);
    }
}
