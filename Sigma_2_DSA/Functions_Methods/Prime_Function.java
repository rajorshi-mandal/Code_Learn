package Functions_Methods;

public class Prime_Function {
    public static void main(String[] args) {
        int n = 37;
        if(isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static boolean isPrime(int n) {
        if(n == 2) {
            return true;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
