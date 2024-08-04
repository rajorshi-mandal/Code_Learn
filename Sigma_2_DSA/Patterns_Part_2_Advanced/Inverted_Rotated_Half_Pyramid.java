package Patterns_Part_2_Advanced;

public class Inverted_Rotated_Half_Pyramid {
    public static void main(String[] args) {
        invertedRotatedHalfPyramid(5);
    }

    public static void invertedRotatedHalfPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
