import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;


public class ReversePolishNotation {
    /**
     * takes a postfix input and evaluated it
     * @param input
     * @return value of input
     */
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

    /**
     * takes an infix expression and converts it into postfix
     * @param input
     * @return postfix representaion of input
     */
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

                if (i == input.length() - 1) {
                    while (!s.isEmpty()) {
                        output += tempArraries[s.peek()];
                        s.pop();
                    }
                }
            }
            else if (input.substring(i, i + 1).equals("+")) {
                if (!s.isEmpty()) {
                    for (int j = 0; j < s.size() + 1; j++) {
                        output += tempArraries[s.pop()];
                    }
                }
                s.push(0);
            }
            else if (input.substring(i, i + 1).equals("-")) {
                for (int j = 0; j < s.size() + 1; j++) {
                    if (!s.isEmpty()) {
                        output += tempArraries[s.pop()];
                    }
                }
                s.push(1);
            }
            else if (input.substring(i, i + 1).equals("/")) {
                if (s.peek() < 2) {
                    s.push(3);

                }
                else {
                    output += "/";
                    s.pop();
                }
            }
            else if (input.substring(i, i + 1).equals("*")) {
                 if (s.peek() < 2) {
                     s.push(2);

                 }
                 else {
                     output += "*";
                     s.pop();
                 }
            }

        }
        return output;
    }
}
