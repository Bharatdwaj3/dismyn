public class WordleCheck {
    public static String checkGuess(String target, String guess) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (guess.charAt(i) == target.charAt(i)) res.append("G");
            else if (target.contains(Character.toString(guess.charAt(i)))) res.append("Y");
            else res.append("B");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(checkGuess("apple", "ample"));
    }
}