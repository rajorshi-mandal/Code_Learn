package OOPS;

public class Abstraction {
    public static void main(String[] args) {
        Horse h1 = new Horse();
        h1.eat();
        h1.walk();
        System.out.println("----------");

        Chicken c1 = new Chicken();
        c1.eat();
        c1.walk();
        System.out.println("----------");

        Mustang m1 = new Mustang();
    }
}

abstract class Animal {
    Animal() {
        System.out.println("Animal Constructor is called ...");
    }

    void eat(){
        System.out.println("Animal eats ...");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse Constructor is called ...");
    }

    void walk(){
        System.out.println("walks on 4 legs ...");
    }
}

class Mustang extends Horse {
    Mustang(){
        System.out.println("Mustang Constructor is called ...");
    }
}

class Chicken extends Animal {
    void walk(){
        System.out.println("walks on 2 legs ...");
    }
}