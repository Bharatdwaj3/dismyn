public class TitleCaseAndPasswordCheck {
    public static String toTitleCase(String s) {
        String[] words = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if (!w.isEmpty())
                sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static boolean isValidPassword(String pwd) {
        return pwd.length() >= 8 && pwd.matches(".*[A-Z].*") &&
               pwd.matches(".*[a-z].*") && pwd.matches(".*\d.*");
    }

    public static void main(String[] args) {
        System.out.println(toTitleCase("hello world from java"));
        System.out.println(isValidPassword("Passw0rd"));
    }
}