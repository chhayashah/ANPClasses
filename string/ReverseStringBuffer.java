// Write a Java program to reverse a given string using StringBuffer

public class ReverseStringBuffer {
    public static void main(String[] args) {
        String s = "Hell o orld";

        StringBuffer str=  new StringBuffer(s);
        String reverse = str.reverse().toString();

        System.out.println("original string: " + s);
        System.out.println("reverse string: " + reverse);
    }
}
