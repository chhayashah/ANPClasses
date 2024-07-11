// Write a Java program to compare two Strings
//  ignoring case using the equalsIgnoreCase() method

public class CompareStringsIgnoreCase {
    public static void main(String[] args){
        String str1 = "Hello, World!";
        String str2 = "hello, world!";
        String str3 = "Hello, Java!";

        boolean isEqual1 = str1.equalsIgnoreCase(str2);
        System.out.println("str1 equalsIgnoreCase str2: " + isEqual1);

        boolean isEqual2 = str1.equalsIgnoreCase(str3);
        System.out.println("str1 equalsIgnoreCase str3: " + isEqual2);
    }
}
