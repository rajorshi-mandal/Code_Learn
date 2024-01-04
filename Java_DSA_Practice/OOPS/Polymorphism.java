package OOPS;

public class Polymorphism {

    public static void methodOverriding(){
        Dear d1 = new Dear();
        d1.eat();
    }

    public static void methodOverloading(){
        Calculator c1 = new Calculator();
        System.out.println(c1.sum(2, 4));
        System.out.println(c1.sum((float)5.3, (float)4.7));
    }

    public static void main(String[] args) {
        // methodOverloading();
        methodOverriding();
    }
}

class Calculator {
    int sum(int a, int b){
        System.out.println("int sum constructor is called ...");
        return a + b;
    }

    float sum(float a, float b){
        System.out.println("float sum constructor is called ...");
        return a + b;
    }
}

class Animal {
    void eat(){
        System.out.println("eats every type of grass ...");
    }
}

class Dear extends Animal {
    void eat(){
        System.out.println("eats wild grass only ...");
    }
}