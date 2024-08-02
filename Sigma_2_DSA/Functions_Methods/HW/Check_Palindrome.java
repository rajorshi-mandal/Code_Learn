package Functions_Methods.HW;

import java.util.Scanner;

public class Check_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        if(isPalindrome(n)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");;
        }
    }

    public static boolean isPalindrome(int n) {
        int rev = 0;
        int pow = 0;
        for(int i = n; i > 0; i /= 10) {
            rev = (rev * 10) + (i % 10);
            pow++;
        }

        System.out.println(rev);
        if(n == rev){
            return true;
        }
        return false;
    }
}
