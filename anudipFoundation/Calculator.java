import java.util.*;

// function overloading
public class Calculator {
    public double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateArea(double length, double width) {
        return length * width;
    }

    public double calculateArea(double base, double height, boolean width) {
        return 0.5 * base * height;
    }

    public static void main(String args[]) {
        Calculator calci = new Calculator();

        double circle = calci.calculateArea(5.0);
        double rectangle = calci.calculateArea(4.0, 5.0);
        double triangle = calci.calculateArea(3.0, 4.0);

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(triangle);
    }
}
