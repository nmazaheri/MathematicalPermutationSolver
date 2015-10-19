import static org.junit.Assert.assertEquals;

/**
 * Created by navid.mazaheri on 10/18/15.
 */
public class InfixToPostfixTest {
    @org.junit.Test
    public void testInfixToPostive() throws Exception {
        assertEquals("4 3 * 2 5 * + 6 2 / -", convertInfixToPostfix("( 4 * 3 ) + 2 * 5 - 6 / 2"));
    }

    private String convertInfixToPostfix(String infix) {
        String[] tokens = infix.split(MathematicalPermutationSolver.STRING_DELIMITER);
        return InfixToPostfix.convert(tokens).trim();
    }
}