package Functions_Methods;

public class Binomial_Coefficient {
    public static void main(String[] args) {
        int n = 5;
        int r = 2;
        
        int res = fact(n) / (fact(r) * fact(n - r));
        System.out.println("Binomial Coefficient : " + res);
    }

    public static int fact(int n) {
        int res = 1;
        for(int i = n; i > 0; i--) {
            res *= i;
        }

        return res;
    }
}
