package Conditional_Statements;

public class Ternary_Operator {
    public static void main(String[] args) {
        int a = 13;
        
        //ternary operator
        String type = ((a % 2 == 0)) ? "even" : "odd";
        System.out.println(type);
    }
}
