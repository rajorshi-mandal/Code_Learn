package Veriables_dataTypes;
import java.util.*;

public class TypeConv {
    public static void main(String[] args) {

        // type compaitable
        //destination type > source type

        int a = 25;
        long b = a; //Error -> long b = 4; int a = b;
        System.out.println(b);

        Scanner sc = new Scanner(System.in);
        float data = sc.nextInt();
        System.out.println(data);

        //Type Casting
        int marks = (int)99.12f; //Lossy conversion -> value lost .12
        System.out.println(marks);

        char ch = 'A';
        int num = ch;
        System.out.println(num);
        
        //Type Promotion
        char var1 = 'a';
        char var2 = 'b';
        System.out.println((int)(var1));
        System.out.println((int)(var2));
        System.out.println(var1); //Tpe Promotions only occur in expressions
        System.out.println(var1 - var2);

        short s = 5;
        byte s2 = 25;
        char c = 'c';
        byte bt = (byte) (c + s + s2); //doesn't make sense just a value
        System.out.println(bt);

        int n1 = 10;
        float n2 = 20.25f;
        long n3 = 25;
        double n4 = 30;
        double ans = n1 + n2 + n3 + n4; //All values um calcualted then converted to double
        System.out.println(ans);

        byte b1 = 5;
        byte bans = (byte) (b1 * 2); //Typecassed to byte since it was converted to int in expression evaluation
        System.out.println(bans);
    }
}
