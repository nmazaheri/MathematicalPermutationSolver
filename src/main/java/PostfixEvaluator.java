import java.util.Stack;

/**
 * Created by navid.mazaheri on 10/18/15.
 */
public class PostfixEvaluator {
    public static int evaluate(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Operator operator;
        for (String s : tokens) {
            if ((operator = getSymbol(s)) == null) {
                stack.push(Integer.valueOf(s));
            } else {
                stack.push(operator.exec(stack.pop(), stack.pop()));
            }
        }
        return stack.pop();
    }

    private static Operator getSymbol(String in) {
        for (Operator op : Operator.values()) {
            if (in.equals(op.getOperator())) {
                return op;
            }
        }
        return null;
    }

    private enum Operator {
        add("+") {
            @Override
            public int exec(int a, int b) {
                return b + a;
            }
        },
        subtract("-") {
            @Override
            public int exec(int a, int b) {
                return b - a;
            }
        },
        divide("/") {
            @Override
            public int exec(int a, int b) {
                return b / a;
            }
        },
        multiply("*") {
            @Override
            public int exec(int a, int b) {
                return b * a;
            }
        };

        private String operator;

        Operator(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }

        public abstract int exec(int a, int b);

    }
}

