package Functions_Methods;

public class Function_Overloading {
    public static void main(String[] args) {
        System.out.println(multiply(4, 3));
        System.out.println(multiply(4.62f, 6.81f));
        System.out.println(multiply(4, 5, 8));

    }

    public static int multiply(int a, int b) {
        return a*b;
    }

    public static float multiply(float a, float b) {
        return a*b;
    }

    public static int multiply(int a, int b, int c) {
        return a*b*c;
    }
}
