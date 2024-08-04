package Functions_Parameters;

public class Factorial {
    public static void main(String[] args) {
        int n = 6;

        int fact = fact(n);
        System.out.println("Factorial : " + fact);
    }

    public static int fact(int n) {
        int res = 1;
        
        for(int i = n;i > 0; i--) {
            res *= i;
        }

        return res;
    }
}
