package Functions_Methods.HW;

public class Average_Three {
    public static void main(String[] args) {
        Double a = 3.45;
        Double b = 5.76;
        Double c = 2.91;
        System.out.println("Avergae of three numbers a = " + a + ", b = " + b + ", c = " + c + " is : " + avg(a, b, c));
    }

    public static Double avg(Double a, Double b, Double c) {
        return (a + b + c)/3;
    }
}
