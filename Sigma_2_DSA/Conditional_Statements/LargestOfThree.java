package Conditional_Statements;

public class LargestOfThree {
    public static void main(String[] args) {
        int a = 50;
        int b = 10;
        int c = 22;

        if(a >= b && a >= c) {
            System.out.println("a is largest");
        } else if(b >= c) {
            System.out.println("b is largest");
        } else {
            System.out.println("c is largest");
        }
    }
}
