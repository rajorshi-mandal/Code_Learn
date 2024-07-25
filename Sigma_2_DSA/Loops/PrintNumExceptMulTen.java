package Loops;

import java.util.Scanner;

public class PrintNumExceptMulTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            int n = sc.nextInt();
            if(n % 10 == 0) {
                continue;
            }
            System.out.print("n = " + n);
            System.out.println();
        } while (true);
    }
}
