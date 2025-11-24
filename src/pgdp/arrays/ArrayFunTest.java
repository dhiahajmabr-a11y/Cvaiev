package pgdp.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayFunTest {

    private static final int[] BASIC_INPUT = {1, 2, 3, 4, 5};

    @Test
    void testPrint() {
        String expected = "{1, 2, 3, 4, 5}";
        ArrayFun.print(BASIC_INPUT);
        assertEquals(expected, getConsoleOutput());
    }

    @Test
    void testMinAndMax() {

    }

    @Test
    void testInvert() {

    }

    @Test
    void testIntersect() {

    }

    @Test
    void testLinearize() {

    }


    // ******************** Helper Functions for capturing output ********************

    private PrintStream old = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        out = new ByteArrayOutputStream();
        old = System.out;
        System.setOut(new PrintStream(out));
    }

    public String getConsoleOutput() {
        String output = out.toString().trim();
        out.reset();
        return output;
    }

    @AfterEach
    public void reset() {
        System.setOut(old);
    }
}