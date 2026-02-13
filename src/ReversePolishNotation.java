import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
public class ReversePolishNotation {
    public static int evaluatePostfix(String input) {
        Stack<Integer> s = new Stack<>();
        String temp  = "";
        for (int i = 0; i < input.length(); i++) {
            temp = input.substring(i, i + 1);
            if (temp.equals("+")) {
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(firstNum + nextNum);
            }
            else if (temp.equals("-")) {
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(nextNum - firstNum);
            }
            else if (temp.equals("/")) {
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(nextNum / firstNum);
            }
            else if (temp.equals("*")) {
                int firstNum = s.pop();
                int nextNum = s.pop();
                s.push(firstNum * nextNum);
            }
            else {
                s.push(Integer.parseInt(temp));
            }
        }
        return s.peek();
    }
    public static String infixToPostfix(String input) {
        Stack<Integer> s = new Stack<>();
        String output = "";
        String letters = "qwertyuiopasdfghjklzxcvbnm";
        String temp = "";
        String[] tempArraries = {"+","-","*", "/"};
        int tempSize = 0;
        for (int i = 0; i < input.length(); i++) {
            if (letters.contains(input.substring(i, i + 1))) {
                output += input.substring(i, i + 1);
                if (i == input.length()) {
                    while (!s.isEmpty()) {
                        output += tempArraries[s.peek()];
                        s.pop();
                    }
                }
            }
            else if (input.substring(i, i + 1).equals("+")) {
                for (int j = 0; j < s.size(); j++) {
                    if (s.peek() > 1 || s.isEmpty()) {
                        output += s.pop();
                    }
                }
                s.push(0);
            }
            else if (input.substring(i, i + 1).equals("-")) {
                if (s.isEmpty()) {
                    throw new EmptyStackException();
                }
                if(s.peek() > 1) {
                    s.push(1);
                }
                else {
                    output += "-";
                }
            }
            else if (input.substring(i, i + 1).equals("/")) {
                if (s.peek() < 2) {
                    s.push(3);
                }
                else {
                    output += "/";
                }
            }
            else if (input.substring(i, i + 1).equals("*")) {
                 if (s.peek() < 2) {
                     s.push(2);
                 }
                 else {
                     output += "*";
                 }
            }

        }
        return output;
    }
}
