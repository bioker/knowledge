package net.wls.learn.encryption;

import net.wls.learn.encryption.rsa.MyRSA;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MyRSATest {

    private static final Logger logger = LogManager.getLogger(MyRSATest.class.getSimpleName());

    private MyRSA myRSA1;

    @Before
    public void init() {
        myRSA1 = new MyRSA();
    }

    // too big data for 2048 rsa key
    @Test(expected = ComparisonFailure.class)
    public void test1() throws IOException {
        logger.info("test1");
        String testData = IOUtils.toString(MyRSATest.class.getResourceAsStream("/rsa_test1_data1"), "UTF-8");
        textTest(myRSA1, testData);
    }

    // too big data for 2048 rsa key
    @Test(expected = ComparisonFailure.class)
    public void test2() throws IOException {
        logger.info("test2");
        String testData = IOUtils.toString(MyRSATest.class.getResourceAsStream("/rsa_test1_data2"), "UTF-8");
        textTest(myRSA1, testData);
    }

    @Test
    public void test3() throws IOException {
        logger.info("test3");
        String testData = IOUtils.toString(MyRSATest.class.getResourceAsStream("/rsa_test1_data3"), "UTF-8");
        textTest(myRSA1, testData);
    }

    @Test
    public void test4() throws IOException {
        logger.info("test4");
        String testData = IOUtils.toString(MyRSATest.class.getResourceAsStream("/rsa_test1_data4"), "UTF-8");
        textTest(myRSA1, testData);
    }

    private void textTest(MyRSA myRSA, String text) throws UnsupportedEncodingException {
        logger.info("encryption");
        logger.debug("text bytes length: " + text.getBytes().length);
        byte[] encrypted = myRSA.encrypt(text.getBytes());
        logger.info("decryption");
        byte[] decrypted = myRSA.decrypt(encrypted);
        logger.debug("decrypted data: " + new String(decrypted, "UTF-8"));
        Assert.assertEquals("decrypted data not equals with initial data",
                text, new String(decrypted, "UTF-8"));
    }
}
