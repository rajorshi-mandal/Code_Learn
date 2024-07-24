package Operators;

class Operations {
    public static void main(String[] args) {
        int A = 10;
        int B = 5;
        
        // Binary Operators
        System.out.println("Binary-----");
        System.out.println("Add : " + (A+B));
        System.out.println("Sub : " + (A-B));
        System.out.println("Product : " + (A*B));
        System.out.println("Divide : " + (A/B));
        System.out.println("Remainder : " + (A%B));

        // Unary Operators
        System.out.println("Unary-----");
        int C = A++;
        B = ++A;
        System.out.println(C);
        System.out.println(B);

        // Relational operators
        System.out.println("Relational-----");
        System.out.println("== " + (A == B));
        System.out.println("!= " + (A != B));
        System.out.println("> " + (A > B));
        System.out.println("< " + (A < B));
        System.out.println(">= " + (A >= B));
        System.out.println("<= " + (A <= B));

        // Logical Operators
        System.out.println("Logical-----");
        System.out.println("&& " + ((3 > 2) && (5 > 2)));
        System.out.println("|| " + ((3 < 2) || (4 > 2)));
        System.out.println("! " + !((5 > 2)));

        //Assignment Operators
        System.out.println("Assignment-----");
        int a = 10;
        int b = 0;
        b += a;

        System.out.println("+= " + b);
    }
}