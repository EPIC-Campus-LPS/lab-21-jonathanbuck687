import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @org.junit.jupiter.api.Test
    void evaluatePostfix() {
        String input = "72+9/35*-";
        assertEquals(-14, ReversePolishNotation.evaluatePostfix(input));
    }

    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        String input = "1+2*3+(4*5+6)*7";
        assertEquals("123*+45*6+7*+", ReversePolishNotation.infixToPostfix(input));
    }
}