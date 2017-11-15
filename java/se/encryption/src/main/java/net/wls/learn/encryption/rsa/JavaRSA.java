package net.wls.learn.encryption.rsa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class JavaRSA {

    private static final Logger logger = LogManager.getLogger(JavaRSA.class.getSimpleName());

    private static final int DEFAULT_KEY_SIZE = 2048;

    private int keySize;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public JavaRSA() throws NoSuchAlgorithmException {
        this(DEFAULT_KEY_SIZE);
    }

    public JavaRSA(int keySize) throws NoSuchAlgorithmException {
        this.keySize = keySize;
        logger.info("JavaRSA creation with key size: " + keySize);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(this.keySize);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
    }

    public byte[] encrypt(byte[] data)
            throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        logger.info("JavaRSA encryption");
        logger.debug("data length: " + data.length);
        return doFinal(data, Cipher.ENCRYPT_MODE, publicKey);
    }

    public byte[] decrypt(byte[] data)
            throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        logger.info("JavaRSA decryption");
        logger.debug("data length: " + data.length);
        return doFinal(data, Cipher.DECRYPT_MODE, privateKey);
    }

    private byte[] doFinal(byte[] data, int cipherMode, Key key)
            throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(cipherMode, key);
        return cipher.doFinal(data);
    }

}
