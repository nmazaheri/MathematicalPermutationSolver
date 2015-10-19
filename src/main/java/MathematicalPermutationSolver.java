import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by navid.mazaheri on 10/18/15.
 */
public class MathematicalPermutationSolver {
    public static final String STRING_DELIMITER = " ";
    public List<Integer> result = new ArrayList();

    public static void main(String[] args) {
        MathematicalPermutationSolver mathematicalPermutations = new MathematicalPermutationSolver();
        mathematicalPermutations.computePermutation(getInputArray());
        mathematicalPermutations.printUniques();
    }

    private static int[] getInputArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a list of numbers separated by a space");
        String[] tokens = in.nextLine().split("\\s");

        int[] functionArgument = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++)
            functionArgument[i] = Integer.parseInt(tokens[i]);
        return functionArgument;
    }

    public List<Integer> computePermutation(int[] in) {
        computePermutations(in, 0, "");
        return result;
    }

    public void printUniques() {
        for (Integer r : new HashSet<Integer>(result)) {
            System.out.println(r);
        }
    }

    public void computePermutations(int[] in, int pos, String expression) {
        expression += in[pos] + STRING_DELIMITER;

        if (pos == in.length - 1) {
            evaluateInfixExpression(expression);
        } else {
            pos++;
            computePermutations(in, pos, expression + "+" + STRING_DELIMITER);
            computePermutations(in, pos, expression + "+" + STRING_DELIMITER + "-");
            computePermutations(in, pos, expression + "*" + STRING_DELIMITER);
        }
    }

    private void evaluateInfixExpression(String infixExpression) {
        String postfixExpression = InfixToPostfix.convert(infixExpression.split(STRING_DELIMITER));
        int expressionResult = PostfixEvaluator.evaluate(postfixExpression.split(STRING_DELIMITER));
        // System.out.printf("%s (infix); %s (postfix); has value %d\n", infixExpression, postfixExpression, expressionResult);
        result.add(expressionResult);
    }
}
