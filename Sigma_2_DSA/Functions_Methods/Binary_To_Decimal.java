package Functions_Methods;

public class Binary_To_Decimal {
    public static void main(String[] args) {
        int n = 1101;
        System.out.println("Binary value = " + n + ", Decimal value = " + binToDec(n));
    }

    public static int binToDec(int n) {
        int res = 0;
        int counter = 0;
        while (n > 0) {
            res += ((n % 10) * Math.pow(2,counter));
            // System.out.println(res);
            counter++;
            n /= 10;
        }

        return res;
    }
}
