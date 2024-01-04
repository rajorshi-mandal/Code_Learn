package OOPS;

public class Class_Object {

    public static void penCall() {
        Pen p1 = new Pen();
        p1.setColor("blue");
        p1.setColor("black");
        p1.setTip(5);

        System.out.println("Pen Tip : " + p1.getTip());
        System.out.println("Pen Color : " + p1.getColor());
    }

    public static void main(String[] args) {
        penCall();
    }
}

class Pen {
    private String color;
    private int tip;

    // Getters
    int getTip() {
        return this.tip;
    }

    String getColor() {
        return this.color;
    }

    // Setters
    void setTip(int newTip) {
        this.tip = newTip;
    }

    void setColor(String newColor) {
        this.color = newColor;
    }
}
