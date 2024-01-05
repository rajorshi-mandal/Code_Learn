package OOPS;

public class static_variable {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("BNV");

        Student s2 = new Student();
        System.out.println(s2.schoolName);
    }
}

class Student {
    String name;
    int roll;

    static String schoolName;

    void setName(String name){
        this.schoolName = name;
    }

    String getName(){
        return this.schoolName;
    }
}