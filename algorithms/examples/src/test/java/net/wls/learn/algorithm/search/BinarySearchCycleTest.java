package net.wls.learn.algorithm.search;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchCycleTest {

    private static SearchTest searchTest;

    @BeforeClass
    public static void init() {
        searchTest = new SearchTest(new BinarySearchCycle());
    }

    @Test
    public void tenTest() {
        Assert.assertFalse(searchTest.test(10, 7));
    }

    @Test
    public void oneHundredTest() {
        Assert.assertFalse(searchTest.test(100, 54));
    }

    @Test
    public void tenThousandTest() {
        Assert.assertTrue(searchTest.test(10000, 4999));
    }

    @Test
    public void oneMillionTest() {
        Assert.assertTrue(searchTest.test(1000000, 54041));
    }

    @Test
    public void oneBillionTest() {
        Assert.assertTrue(searchTest.test(1000000000, 54041));
    }

}
