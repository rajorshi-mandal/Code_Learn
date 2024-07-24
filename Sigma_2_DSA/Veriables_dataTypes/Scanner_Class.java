package Veriables_dataTypes;
import java.util.*;

public class Scanner_Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String input = sc.next(); //capture till next line
        // System.out.println(input);

        // String name = sc.nextLine();  //includes all spaces 
        // System.out.println(name);

        int number = sc.nextInt();
        System.out.println(number);

        float price = sc.nextFloat();
        System.out.println(price);
    }
}
