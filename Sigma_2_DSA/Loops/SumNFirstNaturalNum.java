package Loops;

import java.util.Scanner;

public class SumNFirstNaturalNum {
    public static void main(String[] args) {
        int counter = 1;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();

        while (counter <= range) {
            sum += counter;
            counter++;
        }
        System.out.println("Sum : " + sum);
    }
}
