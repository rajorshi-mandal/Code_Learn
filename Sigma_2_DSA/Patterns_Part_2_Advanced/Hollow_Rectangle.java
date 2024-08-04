package Patterns_Part_2_Advanced;

public class Hollow_Rectangle {
    public static void main(String[] args) {
        hollowRectangle(4, 8);
    }

    public static void hollowRectangle(int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
