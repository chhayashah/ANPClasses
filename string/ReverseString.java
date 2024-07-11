public class ReverseString {
    public static void main(String[] args) {
        String s = "hello, world";

        String rev = reverse(s);
        System.out.println(rev);
    }

    public static String reverse(String str) {
        char[] charArray = str.toCharArray();

        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}
