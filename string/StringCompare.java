
// Write a Java program to compare two Strings using the equals() method

public class StringCompare {
    public static void main(String[] args) {

        String str1 = "Hello, World!";
        String str2 = "Hello, Java!";
        String str3 = "Hello, World!";

        boolean isEqual1 = str1.equals(str2);
        System.out.println("str1 equals str2: " + isEqual1);

        boolean isEqual2 = str1.equals(str3);
        System.out.println("str1 equals str3: " + isEqual2);

        String a = "chhaya";
        String b = "chhaya";

        String c = "shah";
        System.out.println(a == b);
        System.out.println(b == a);
        System.out.println(c == b);

    }
}
