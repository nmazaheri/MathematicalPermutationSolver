import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by navid.mazaheri on 10/18/15.
 */
public class InfixToPostfix {
    private static List<String> operators = Arrays.asList("/", "*", "+", "-", "(", ")");

    public static String convert(String[] tokens) {
        Stack<String> operatorStack = new Stack();
        StringBuilder postfix = new StringBuilder();

        for (String token : tokens) {
            if (isOperator(token)) {
                handleOperator(operatorStack, postfix, token);
            } else {
                // handle operand
                appendToken(postfix, token);
            }
        }
        while (!operatorStack.isEmpty()) {
            appendToken(postfix, operatorStack.pop());
        }
        return postfix.toString();
    }

    private static boolean isOperator(String token) {
        return operators.contains(token);
    }

    private static void appendToken(StringBuilder postfix, String token) {
        postfix.append(token).append(MathematicalPermutationSolver.STRING_DELIMITER);
    }

    private static void handleOperator(Stack<String> operatorStack, StringBuilder postfix, String token) {
        if (")".equals(token))
            handleParentheses(operatorStack, postfix);
        else if ("(".equals(token))
            operatorStack.add(token);
        else
            handleMathOperator(operatorStack, token, postfix);
    }

    private static void handleParentheses(Stack<String> operatorStack, StringBuilder postfix) {
        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            if ("(".equals(operator))
                break;

            appendToken(postfix, operator);
        }
    }

    private static void handleMathOperator(Stack<String> operatorStack, String token, StringBuilder postfix) {
        if (!operatorStack.isEmpty() && isLowerPrecedence(token, operatorStack.peek())) {
            while (!operatorStack.isEmpty()) {
                appendToken(postfix, operatorStack.pop());
            }
        }
        operatorStack.add(token);
    }

    private static boolean isLowerPrecedence(String op1, String op2) {
        if ("+".equals(op1) || "-".equals(op1) && ("*".equals(op2) || "/".equals(op2)))
            return true;
        else
            return false;
    }
}
