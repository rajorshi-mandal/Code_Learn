package Functions_Methods;

public class PrimesInRange {
    public static void main(String[] args) {
        int range = 100;

        for(int i = 2; i <= range; i++) {
            if(isPrime(i)) {
                System.out.print(i + ",");
            }
        }
        System.out.println();
    }

    public static boolean isPrime(int n) {
        if(n == 2){
            return true;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
