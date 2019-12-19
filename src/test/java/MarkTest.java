import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MarkTest {

    @Test
    public void test() {
        double expected = 16;
        double result = Mark.getMarkTable(0, 0);
        assertEquals(result, expected, 1);

        double expected_2 = 2;
        double result_2 = Mark.getMarkTable(25, 1);
        assertEquals(result_2, expected_2, 1);

    }
}