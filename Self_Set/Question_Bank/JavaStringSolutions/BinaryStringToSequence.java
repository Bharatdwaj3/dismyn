public class BinaryStringToSequence {
    public static String binaryToSequence(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            if (i + 1 < s.length()) {
                String pair = s.substring(i, i + 2);
                if (pair.equals("00")) sb.append("A");
                else if (pair.equals("01")) sb.append("B");
                else if (pair.equals("10")) sb.append("C");
                else sb.append("D");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(binaryToSequence("00011011"));
    }
}