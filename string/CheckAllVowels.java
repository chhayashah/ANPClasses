// Write a Java program to check whether a given string contains all the vowels (a, e, i, o, u) at least once.
// Input: str = "hello" Output: false

import java.util.HashSet;
import java.util.Set;

public class CheckAllVowels {
    public static void main(String[] args) {
        String str = "hello";

        boolean result = containsAllVowels(str);

        System.out.println("Input: str = \"" + str + "\" Output: " + result);
    }

    public static boolean containsAllVowels(String str) {
         Set<Character> vowelsFound = new HashSet<>();

         str = str.toLowerCase();
         for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // If the character is a vowel, add it to the set
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelsFound.add(ch);
            }
        }
            return vowelsFound.contains('a') && vowelsFound.contains('e') &&
               vowelsFound.contains('i') && vowelsFound.contains('o') &&
               vowelsFound.contains('u');
     }
}
