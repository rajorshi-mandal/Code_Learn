public class inverted_half_pyramid_numbers {

    public static void invertedHalfPyramidNum(int n){
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(j);
            }
            System.out.println();
        } 
        //method 2 -> i = 1 to n and j 1 to n - i - 1
    }

    public static void flyodsTriangle(int n){
        int k = 1; //counter
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if((i + j) % 2 == 0){
                    System.out.print("1" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void butterflyPattern(int n){
        //first half
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            for(int k = 2 * (n - i); k > 0; k--){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //second half
        for(int i = n; i >= 1; i--){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            for(int k = 2 * (n - i); k > 0; k--){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < n; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollowRhombus(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n - i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= n; k++){
                if( i == 1 || k == 1 || i == n || k == n){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n){

        //first half
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n - i;j++){
                System.out.print(" ");
            }
            for(int k = 0; k < 2 * i - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = n; i >= 1; i--){
            for(int j = 0; j < n - i;j++){
                System.out.print(" ");
            }
            for(int k = 0; k < 2 * i - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // flyodsTriangle(5);
        // zeroOneTriangle(5);
        // butterflyPattern(4);
        // solidRhombus(5);
        // hollowRhombus(5);
        diamond(3);
    }
}