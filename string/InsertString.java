// write a Java program to insert a string at a 
// specific position in another string using StringBuffer

public class InsertString {
    public static void main(String[] args) {
        String s = "chhaya shah";
        String str = "java";

        int position = 6;

        StringBuffer stringBuffer = new StringBuffer(s);
        stringBuffer.insert(position, str);

        String modifiedString = stringBuffer.toString();

        System.out.println("Original String: " + s);
        System.out.println("Modified String: " + modifiedString);
    }
}
