package pgdp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PenguinBarTest {
    // DO NOT MODIFY THIS FIELD
    protected PenguinBar penguinBar;

    @BeforeEach
    protected void setUp() {
        // DO NOT INITIALIZE YOUR OWN OBJECTS FOR TESTING; ONLY USE THIS!
        // DO NOT MODIFY THIS METHOD.
        // You can create more methods with the @BeforeEach annotation,
        // if you need to set up anything for your test cases.
        this.penguinBar = new PenguinBar();
    }

    @Test
    public void exampleTest() {
        // Implement tests like this for PenguinBar.
        assertEquals(42, 42);
    }
}
