import java.util.ArrayDeque;
import java.util.Deque;


public class ParenthesizedExpression {
    String expression;


    public ParenthesizedExpression(String expression) throws Exception {
        if (expression == null || expression.isEmpty()) {
            throw new Exception("Expression cannot be null or empty");
        }

        this.expression = expression;
        validate();
    }
     
    private void validate() throws Exception {
        Deque<Character> stack = new ArrayDeque<>(); 
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    throw new Exception("Unmatched closing parenthesis found");
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            throw new Exception("Unmatched opening parenthesis found");
        }
    }
    public String getExpression() {
        return expression;
    }
}
