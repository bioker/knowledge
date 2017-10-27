package net.wls.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {

    private static SortTest sortTest;

    @BeforeClass
    public static void init() {
        sortTest = new SortTest(new BubbleSort());
    }

    @Test
    public void tenTest() {
        Assert.assertTrue(sortTest.test(10));
    }

    @Test
    public void oneHundredTest() {
        Assert.assertTrue(sortTest.test(100));
    }

    @Test
    public void tenThousandTest() {
        Assert.assertTrue(sortTest.test(10000));
    }

    @Test
    public void oneMillionTest() {
        Assert.assertTrue(sortTest.test(1000000));
    }


}
