package Patterns_Part_2_Advanced;

public class Solid_Rhombus_Pattern {
    public static void main(String[] args) {
        soldRhombusPattern(5);
    }

    public static void soldRhombusPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
