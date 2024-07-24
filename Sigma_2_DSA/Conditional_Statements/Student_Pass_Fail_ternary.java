package Conditional_Statements;

public class Student_Pass_Fail_ternary {
    public static void main(String[] args) {
        int marks = 32;

        String status = (marks >= 33) ? "pass" : "fail";
        System.out.println(status);
    }
}
