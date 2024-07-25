package Loops;

public class While {
    public static void main(String[] ars) {
        int counter = 0;

        while(counter < 10) {
            System.out.println(counter + " : Hello World");
            counter++;
        }
        System.out.println("Printed Hello World : " + counter + " times");
    }
}
