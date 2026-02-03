import java.util.ArrayList;

public class ReversePolishNotation {
    public static int evaluatePostfix(String input) {
        Stack s = new Stack();
        String temp  = "";
        for (int i = 0; i < input.length()  - 1; i++) {
            temp = input.substring(i, i + 1);
            if (temp.equals("+")) {
                s.push(s.pop() + s.pop());
            }
            else if (temp.equals("-")) {
                s.push(s.pop() - s.pop());
            }
            else if (temp.equals("/")) {
                s.push(s.pop() / s.pop());
            }
            else if (temp.equals("*")) {
                s.push(s.pop() * s.pop());
            }
            else {
                s.push(Integer.parseInt(temp));
            }
        }
        return s.peek();
    }
    public static String infixToPostfix(String input) {
        Stack s = new Stack();
        String output = "";
        String numbers = "0123456789";
        for (int i = 0; i < input.length() - 1; i++) {
            if (numbers.contains(input.substring(i, i + 1)));
        }
    }
}
