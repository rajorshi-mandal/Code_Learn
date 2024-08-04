package Patterns_Part_2_Advanced;

public class Inverted_Half_Pyramid_Numbers {
    public static void main(String[] args) {
        invertedHalfPyramidNumbers(5);
    }

    public static void invertedHalfPyramidNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
