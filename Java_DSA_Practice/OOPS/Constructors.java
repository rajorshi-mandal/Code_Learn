package OOPS;

public class Constructors {
    public static void studentCall() {
        Student s1 = new Student();
        Student s2 = new Student("Rajorshi");
        Student s3 = new Student(12345);
        // Student s4 = new Student("Rajorshi",12345);

        System.out.println(s1);
        System.out.println(s2.name);
        System.out.println(s3.roll);
    }

    public static void copyConstructor() {
        Student s1 = new Student();
        s1.name = "Rajorshi";
        s1.roll = 50;
        s1.password = "random1";

        s1.marks[0] = 68;
        s1.marks[1] = 62;
        s1.marks[2] = 65;

        Student s2 = new Student(s1);

        s2.password = "random2";
        s2.marks[0] = 69;

        for (int i = 0; i < s2.marks.length; i++) {
            System.out.print(s2.marks[i] + " ");
        }
        System.out.println();

        System.out.println(s1.password);
        System.out.println(s2.password);
    }

    public static void main(String[] args) {
        // studentCall();
        copyConstructor();
    }
}


class Student {
    String name;
    int roll;
    String password;
    int[] marks;
    
    //shallow copy constructor
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.password = s1.password;
        this.marks = s1.marks;
    }

    //deep copy constructor
    // Student(Student s1){
    //     marks = new int[s1.marks.length];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.password = s1.password;
    //     for(int i = 0; i < s1.marks.length; i++){
    //         this.marks[i] = s1.marks[i];
    //     }
    // }

    Student() {
        marks = new int[3];
        System.out.println("Constructor is called .......");
    }

    Student(String name) {
        marks = new int[3];
        this.name = name;
    }

    Student(int roll) {
        marks = new int[3];
        this.roll = roll;
    }
}