package Strings;

import java.util.Scanner;

public class String_operations {

    public static void isPalindrome(String str) { //O(N)
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                System.out.println("Not Palindrome !!");
                return;
            }
        }
        System.out.println("Palindrome");
    }

    public static void shortestPathRoute(String route) { //O(N)
        int x = 0, y = 0;
        for (int i = 0; i < route.length(); i++) {
            if (route.charAt(i) == 'E') {
                x++;
            } else if (route.charAt(i) == 'W') {
                x--;
            } else if (route.charAt(i) == 'N') {
                y++;
            } else {
                y--;
            }
        }

        double shortestPath = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        System.out.println("Shortest route is : " + shortestPath);
    }

    public static void largestStringLexicographically(String[] strArr){ //O(N)

        String largest = "";

        for(int i = 0; i < strArr.length - 1; i++){
            if(strArr[i].compareTo(strArr[i + 1]) < 0){
                largest = strArr[i + 1];
            }
        }

        System.out.println("Lexicographically Largest String : " + largest);
    }

    public static void firstLetterUppercase(String sentence){
        //Using StringBuilder Class not string 
        StringBuilder sb = new StringBuilder("");

        sb.append(Character.toUpperCase(sentence.charAt(0)));

        for(int i = 1; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' ' && i < sentence.length() - 1){
                sb.append(sentence.charAt(i));
                i++;
                sb.append(Character.toUpperCase(sentence.charAt(i))); //Character.toUpperCase(str)
            } else {
                sb.append(sentence.charAt(i));
            }
        }

        System.out.println("After First Letter UpperCase Conversion : " + sb.toString());
    }

    public static void stringCompression(String str){

        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < str.length(); i++){
            Integer count = 1;

            while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
                count++;
                i++;
            }

            sb.append(str.charAt(i));
            if(count > 1){
                sb.append(count.toString());
            }
        }

        System.out.println("Compressed String : " + sb.toString());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Choice :\n1. Palindrome - O(N)\n2. Shortest Route (EWNS) - O(N)\n3. Largest String Lexicographically - O(N)\n4. Convert First Letter to UpperCase - O(N)\n5. String Compression\n:");
        int choice = sc.nextInt();

        //Consume the newline character
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the String : ");
                String input = sc.next();
                isPalindrome(input);
                break;
            case 2:
                System.out.print("Enter the String : ");
                input = sc.next();
                shortestPathRoute(input);
                break;
            case 3:
                System.out.print("Enter the String Array Length : ");
                int n = sc.nextInt();
                String[] strArr = new String[n];
                for(int i = 0; i < n; i++){
                    strArr[i] = sc.next();
                }
                largestStringLexicographically(strArr);
                break;
            case 4:
                System.out.print("Enter the sentence(String) : ");
                input = sc.nextLine();
                firstLetterUppercase(input);
                break;
            case 5:
                System.out.print("Enter the String : ");
                input = sc.next();
                stringCompression(input);
                break;
            default:
                break;
        }
    }
}
