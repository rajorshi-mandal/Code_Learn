package Functions_Parameters;

public class Product {

    public static int multiply(int a, int b) {
        return a*b;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 8;

        int res = multiply(a,b);

        System.out.println("a * b = " + res);
    }
}
