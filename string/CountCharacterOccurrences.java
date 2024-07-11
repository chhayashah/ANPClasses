// Write a Java program to count the number of
//  occurrences of a specific character in a String

public class CountCharacterOccurrences {
    public static void main(String[] args) {
        String s = "hello world";
        char targetChar = 'o';

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == targetChar) {
                count++;
            }
        }

        System.out.println("original strings: " + s);
        System.out.println("Occurrences of '" + targetChar + "': " + count);
    }
}
