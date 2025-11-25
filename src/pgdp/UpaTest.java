package pgdp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpaTest {
    // DO NOT MODIFY THIS FIELD
    protected Utils utils;
    protected Bag bag;

    @BeforeEach
    protected void setUp() {
        // DO NOT INITIALIZE YOUR OWN OBJECTS FOR TESTING; ONLY USE THIS!
        // DO NOT MODIFY THIS METHOD.
        // You can create more methods with the @BeforeEach annotation,
        // if you need to set up anything for your test cases.
        this.utils = new Utils();
        this.bag = new Bag();
    }

    @BeforeEach
    protected void setUpFullBag() {
        this.utils = new Utils();
        this.bag = new Bag();

        bag.add(10);
        bag.add(20);
        bag.add(30);
    }

    @BeforeEach
    protected void setUpBagWithDuplicates() {
        this.utils = new Utils();
        this.bag = new Bag();

        bag.add(5);
        bag.add(5);
        bag.add(10);
    }

    @BeforeEach
    protected void setUpBagWithNegativeNumbers() {
        this.utils = new Utils();
        this.bag = new Bag();
        bag.add(-1);
        bag.add(-5);
    }

    @Test
    public void testUseless() {
        assertTrue(true);
    }

    @Test
    public void testFullBagOperations() {
        assertFalse(bag.add(40)); 
        assertTrue(bag.contains(10));
        assertTrue(bag.contains(20));
        assertTrue(bag.contains(30));
    }

    @Test
    public void testRemoveFromFullBag() {
        assertTrue(bag.remove(20));
        assertTrue(bag.add(40));
        assertTrue(bag.contains(40));
    }

    @Test
    public void testBagWithDuplicates() {
        assertTrue(bag.contains(5));
        assertTrue(bag.remove(5)); 
        assertTrue(bag.contains(5)); 
    }

    @Test
    public void testBagWithNegativeNumbers() {
        assertTrue(bag.contains(-1));
        assertTrue(bag.contains(-5));
        assertTrue(bag.remove(-1));
        assertFalse(bag.contains(-1));
    }

    @Test
    public void testGcdBasicCases() {
        assertEquals(6, utils.gcd(54, 24));
        assertEquals(1, utils.gcd(17, 13));
        assertEquals(5, utils.gcd(15, 10));
    }

    @Test
    public void testGcdWithZero() {
        assertEquals(5, utils.gcd(5, 0));
        assertEquals(7, utils.gcd(0, 7));
    }

    @Test
    public void testGcdEqualNumbers() {
        assertEquals(8, utils.gcd(8, 8));
        assertEquals(1, utils.gcd(1, 1));
    }

    @Test
    public void testSortBasic() {
        int[] input = {3, 1, 4, 1, 5};
        int[] expected = {1, 1, 3, 4, 5};
        assertArrayEquals(expected, utils.sort(input));
    }

    @Test
    public void testSortEmpty() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, utils.sort(input));
    }

    @Test
    public void testSortSingleElement() {
        int[] input = {42};
        int[] expected = {42};
        assertArrayEquals(expected, utils.sort(input));
    }

    @Test
    public void testSortNull() {
        assertNull(utils.sort(null));
    }

    @Test
    public void testValidDates() {
        assertTrue(utils.isValidDate(1, 1, 2023));
        assertTrue(utils.isValidDate(31, 12, 2023));
        assertTrue(utils.isValidDate(29, 2, 2020)); 
        assertTrue(utils.isValidDate(28, 2, 2021)); 
    }

    @Test
    public void testInvalidDates() {
        assertFalse(utils.isValidDate(0, 1, 2023));
        assertFalse(utils.isValidDate(32, 1, 2023));
        assertFalse(utils.isValidDate(29, 2, 2021)); 
        assertFalse(utils.isValidDate(31, 4, 2023)); 
        assertFalse(utils.isValidDate(15, 13, 2023));
        assertFalse(utils.isValidDate(15, 0, 2023));
        assertFalse(utils.isValidDate(15, 5, -1));
    }

    @Test
    public void testBagAddWithinCapacity() {
        assertTrue(bag.add(1));
        assertTrue(bag.add(2));
        assertTrue(bag.add(3));
    }

    @Test
    public void testBagAddBeyondCapacity() {
        bag.add(1);
        bag.add(2);
        bag.add(3);
        assertFalse(bag.add(4));
    }

    @Test
    public void testBagContains() {
        bag.add(5);
        bag.add(10);
        
        assertTrue(bag.contains(5));
        assertTrue(bag.contains(10));
        assertFalse(bag.contains(15));
    }

    @Test
    public void testBagContainsEmpty() {
        assertFalse(bag.contains(5));
    }

    @Test
    public void testBagRemoveExisting() {
        bag.add(5);
        bag.add(10);
        
        assertTrue(bag.remove(5));
        assertFalse(bag.contains(5));
        assertTrue(bag.contains(10));
    }

    @Test
    public void testBagRemoveNonExisting() {
        bag.add(5);
        bag.add(10);
        
        assertFalse(bag.remove(15));
        assertTrue(bag.contains(5));
        assertTrue(bag.contains(10));
    }

    @Test
    public void testBagRemoveFromEmpty() {
        assertFalse(bag.remove(5));
    }

    @Test
    public void testBagAddAfterRemove() {
        bag.add(1);
        bag.add(2);
        bag.add(3);
        
        bag.remove(2);
        
        assertTrue(bag.add(4));
        assertTrue(bag.contains(4));
    }

    @Test
    public void testBagIntegration() {
        assertTrue(bag.add(1));
        assertTrue(bag.contains(1));
        
        assertTrue(bag.add(2));
        assertTrue(bag.contains(2));
        
        assertTrue(bag.add(3));
        assertTrue(bag.contains(3));
        
        assertFalse(bag.add(4));
        
        assertTrue(bag.remove(2));
        assertFalse(bag.contains(2));
        
        assertTrue(bag.add(4));
        assertTrue(bag.contains(4));
    }
}