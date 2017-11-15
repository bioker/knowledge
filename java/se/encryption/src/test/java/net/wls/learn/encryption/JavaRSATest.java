package net.wls.learn.encryption;

import net.wls.learn.encryption.rsa.JavaRSA;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class JavaRSATest {

    private static final Logger logger = LogManager.getLogger(JavaRSATest.class.getSimpleName());

    private JavaRSA javaRSA1;

    @Before
    public void init() throws NoSuchAlgorithmException {
        javaRSA1 = new JavaRSA();
    }

    // too big data
    @Test(expected = IllegalBlockSizeException.class)
    public void test1() throws IOException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        logger.info("test1");
        String testData = IOUtils.toString(JavaRSATest.class.getResourceAsStream("/rsa_test1_data1"), "UTF-8");
        textTest(javaRSA1, testData);
    }

    // too big data
    @Test(expected = IllegalBlockSizeException.class)
    public void test2() throws IOException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        logger.info("test2");
        String testData = IOUtils.toString(JavaRSATest.class.getResourceAsStream("/rsa_test1_data2"), "UTF-8");
        textTest(javaRSA1, testData);
    }

    // too big data
    @Test(expected = IllegalBlockSizeException.class)
    public void test3() throws IOException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        logger.info("test3");
        String testData = IOUtils.toString(JavaRSATest.class.getResourceAsStream("/rsa_test1_data3"), "UTF-8");
        textTest(javaRSA1, testData);
    }

    @Test
    public void test4() throws IOException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        logger.info("test4");
        String testData = IOUtils.toString(JavaRSATest.class.getResourceAsStream("/rsa_test1_data4"), "UTF-8");
        textTest(javaRSA1, testData);
    }

    private void textTest(JavaRSA javaRSA, String text)
            throws UnsupportedEncodingException, IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        logger.info("encryption");
        logger.debug("text bytes length: " + text.getBytes().length);
        byte[] encrypted = javaRSA.encrypt(text.getBytes());
        logger.info("decryption");
        byte[] decrypted = javaRSA.decrypt(encrypted);
        logger.debug("decrypted data: " + new String(decrypted, "UTF-8"));
        Assert.assertEquals("decrypted data not equals with initial data",
                text, new String(decrypted, "UTF-8"));
    }
}
