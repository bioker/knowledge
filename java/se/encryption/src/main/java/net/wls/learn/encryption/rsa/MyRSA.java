package net.wls.learn.encryption.rsa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;

public class MyRSA {

    private static final Logger logger = LogManager.getLogger(MyRSA.class.getSimpleName());

    private static final int DEFAULT_KEY_SIZE = 2048;

    private BigInteger module;
    private BigInteger secretExponent;
    private BigInteger publicExponent;
    private int keySize;

    public MyRSA(BigInteger module, BigInteger secretExponent, BigInteger publicExponent, int keySize) {
        this.module = module;
        this.secretExponent = secretExponent;
        this.publicExponent = publicExponent;
        this.keySize = keySize;
    }

    public MyRSA(BigInteger module, BigInteger secretExponent, BigInteger publicExponent) {
        this(module, secretExponent, publicExponent, DEFAULT_KEY_SIZE);
    }

    public MyRSA() {
        logger.info("random generated rsa instance creation");
        keySize = DEFAULT_KEY_SIZE;
        Random random = new Random();

        BigInteger p = BigInteger.probablePrime(keySize, random);
        BigInteger q = BigInteger.probablePrime(keySize, random);
        logger.debug("p number: " + p);
        logger.debug("q number: " + q);

        module = p.multiply(q);
        logger.debug("module: " + module);

        BigInteger eulerFunctionValue = p
                .subtract(BigInteger.ONE)
                .multiply(q.subtract(BigInteger.ONE));
        logger.debug("euler function value: " + eulerFunctionValue);

        publicExponent = generatePublicExponent(eulerFunctionValue, p, q, random);
        secretExponent = generateSecretExponent(eulerFunctionValue, publicExponent);
        logger.debug("public exponent: " + publicExponent);
        logger.debug("secret exponent: " + secretExponent);
    }

    public byte[] encrypt(byte[] data) {
        return new BigInteger(data).modPow(publicExponent, module).toByteArray();
    }

    public byte[] decrypt(byte[] data) {
        return new BigInteger(data).modPow(secretExponent, module).toByteArray();
    }

    private BigInteger generatePublicExponent(BigInteger eulerFunctionValue, BigInteger p, BigInteger q, Random random) {
        BigInteger publicExponent = BigInteger.probablePrime(keySize / 2, random);
        while (eulerFunctionValue.gcd(publicExponent).compareTo(BigInteger.ONE) > 0 &&
                publicExponent.compareTo(eulerFunctionValue) < 0) {
            publicExponent.add(BigInteger.ONE);
        }
        return publicExponent;
    }

    private BigInteger generateSecretExponent(BigInteger eulerFunctionValue, BigInteger publicExponent) {
        return publicExponent.modInverse(eulerFunctionValue);
    }

    public int getKeySize() {
        return keySize;
    }
}
