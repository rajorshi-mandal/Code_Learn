package Veriables_dataTypes.HW;
import java.util.*;

public class PriceFLoat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float pencil = sc.nextInt();
        float pen = sc.nextInt();
        float eraser = sc.nextInt();

        float total_cost = pencil + pen + eraser;
        float gst_add_cost = (float) ((total_cost * 0.18f) + total_cost);
        System.out.println("Total cost with GST : " + gst_add_cost);
    }
}
