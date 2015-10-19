import static org.junit.Assert.assertEquals;

/**
 * Created by navid.mazaheri on 10/18/15.
 */
public class PostfixEvaluatorTest {

    @org.junit.Test
    public void testPostfixEvaluation() throws Exception {
        assertEquals(4, PostfixEvaluator.evaluate(new String[] { "2", "5", "3", "-", "+" }));
        assertEquals(0, PostfixEvaluator.evaluate(new String[] { "2", "5", "3", "-", "-" }));
    }
}