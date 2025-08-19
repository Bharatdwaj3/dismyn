import java.util.Scanner;
import java.util.Stack;

public class ParenthesesValidator {

    // Function to check if characters match
    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    // Function to check if the parentheses string is valid
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isMatching(stack.peek(), ch)) {
                    return false;
                }
                stack.pop(); // matched, so pop
            }
        }

        return stack.isEmpty(); // if stack is empty, it's valid
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string of parentheses: ");
        String input = scanner.nextLine();

        if (isValidParentheses(input)) {
            System.out.println("The parentheses string is VALID.");
        } else {
            System.out.println("The parentheses string is INVALID.");
        }

        scanner.close();
    }
}
