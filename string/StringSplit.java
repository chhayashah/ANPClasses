public class StringSplit {
    public static void main(String[] args) {
        String s = "hello, how,are,you?";

        String[] substrings = s.split(",");

        for (String substring : substrings) {
            System.out.println(substring);
        }
    }
}
