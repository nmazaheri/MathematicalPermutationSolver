import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by navid.mazaheri on 10/18/15.
 */
public class MathematicalPermutationSolverTest {

    @Test
    public void testComputePermutations() throws Exception {
        MathematicalPermutationSolver mathematicalPermutations = new MathematicalPermutationSolver();
        List<Integer> actual = mathematicalPermutations.computePermutation(new int[] { 2, 5, 3 });
        assertListsContainSameElements(actual, Arrays.asList(0, 17, -13, 4, 7, -6, 10, 13, 30));
    }

    private void assertListsContainSameElements(List<Integer> actual, List<Integer> expected) {
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}