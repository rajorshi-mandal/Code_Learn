package Functions_Methods;

public class Decimal_To_Binary {
    public static void main(String[] args) {
        int n = 29;
        System.out.println("Binary value = " + n + ", Binary value = " + decToBin(n));
    }

    public static int decToBin(int n) {
        int res = 0;
        int pow = 0;
        while(n > 0) {
            // res = (res * 10) + (n  % 2);
            res += (n % 2) * Math.pow(10,pow); //the counter logic for this code is self made
            pow++;
            n /= 2;
        }

        return res;
    }

    // public static int decToBin(int n) {
    //     int res = 0;
    //     int counter = 1;
    //     while(n > 0) {
    //         // res = (res * 10) + (n  % 2);
    //         res += (n % 2) * counter; //the counter logic for this code is self made
    //         counter *= 10;
    //         n /= 2;
    //     }

    //     return res;
    // }
}
