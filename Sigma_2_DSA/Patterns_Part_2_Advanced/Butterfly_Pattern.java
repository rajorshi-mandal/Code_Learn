package Patterns_Part_2_Advanced;

public class Butterfly_Pattern {
    public static void main(String[] args) {
        butterflyPattern(6);
    }

    public static void butterflyPattern(int n) {
        for (int i = 1; i <= n; i++) {
            //1st pyramid
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // System.out.println();

            //middle space region
            for (int j = 1; j <= 2*(n - i); j++) {
                System.out.print(" ");
            }
            // System.out.println();

            //2nd pyramid
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n; i >= 1; i--) {
            //1st pyramid
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // System.out.println();

            //middle space region
            for (int j = 1; j <= 2*(n - i); j++) {
                System.out.print(" ");
            }
            // System.out.println();

            //2nd pyramid
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
