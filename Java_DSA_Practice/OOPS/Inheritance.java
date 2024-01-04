package OOPS;

public class Inheritance {
    public static void main(String[] args) {
        Fish toona = new Fish();
        toona.swim();
        toona.eat();

        Bird owl = new Bird();
        owl.fly();
        owl.breathe();
    }
}

class Animal { //base class
    String color;

    void eat(){
        System.out.println("eats ...");
    }

    void breathe(){
        System.out.println("breathes ...");
    }
}

class Fish extends Animal {//derived class
    int fins;

    void swim(){
        System.out.println("Swims in water ...");
    }
}

class Bird extends Animal { //derived class
    int wings;

    void fly(){
        System.out.println("Flies in sky");
    }
}