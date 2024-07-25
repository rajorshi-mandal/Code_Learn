package Loops;

import java.util.Scanner;

public class PrintOneToRange {
    public static void main(String[] args) {
        int counter = 1;

        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();

        while(counter <= range) {
            System.out.print(counter + " ");
            counter++;
        }
        System.out.println();
    }
}
