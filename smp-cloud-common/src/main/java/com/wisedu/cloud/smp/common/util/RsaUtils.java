package com.wisedu.cloud.smp.common.util;



import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by luqiang on 2016/6/20.
 */
public class RsaUtils {
    private static final String KEY_ALGORITHM = "RSA";
    private static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDnKuLd5bAnBKb7fS1E74qaa0lD\n" +
            "vvRw/E/TrPWaBV4K5l+wpnvl9LpOYsjobioLptqLeOCIg1lLL8l60h1h+LFDdPH2\n" +
            "sloTrqlZh+PIHKY0NCbOP1n6m0ZC5LzAx47BOPJZ+lS6qzSSdM1kigfik6mcThSG\n" +
            "Es8mTA6hb9kz91svfQIDAQAB";
    private static final String RSA_PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAOcq4t3lsCcEpvt9\n" +
            "LUTvipprSUO+9HD8T9Os9ZoFXgrmX7Cme+X0uk5iyOhuKgum2ot44IiDWUsvyXrS\n" +
            "HWH4sUN08fayWhOuqVmH48gcpjQ0Js4/WfqbRkLkvMDHjsE48ln6VLqrNJJ0zWSK\n" +
            "B+KTqZxOFIYSzyZMDqFv2TP3Wy99AgMBAAECgYBK8bVxWSjdzX1RZUjK45oc7BFp\n" +
            "nDvlcXdz2cwaLglKIVv+ikr6x3erOA2IhUauVl7d/sdUmrjVTl3UqtAJ1jWpWjhw\n" +
            "Cv7v1aC82bCmEg3CmPqLWyxS6X3wvxu0rhKl/zd36CTBRzPIoQ5DeekgW1lGBnhY\n" +
            "JFhn+ysRppCWVNoz4QJBAPhjXA7m0PaNsSzoTO87TREcJkREFCawBUA37PxbVWtR\n" +
            "SE0WS0tlUiDqCD7pR7jJVHnXbjfNPMfh8PAZmjeLSjUCQQDuQG20E+il2/x5hRrg\n" +
            "EQwkSwErS+bX279JZpNPu7dBEyUtIiz2RhQDqB9WL2K2znrlEPmtVghdwzRpyvCR\n" +
            "PLkpAkEA1QIQTk8u4GE+ka5dW8NVIdksD9r6FPtaZWoQd5GzvSalhEYcJ/op5kQM\n" +
            "8jaH5TXyldJjmMMO3rMqNh0enYd8CQJBAOK/1OjPDdtU3Bw3jxVzhA/ChrFTQrdr\n" +
            "/8j24/q9mDJJ61biMNKObZvxVSmsXZHIP/RkzIuo1ruN/gM1zvEbTskCQQDKSZMJ\n" +
            "X6GSmCVdmNFF/P4PtWDXrnaNpMxIw0v6YrsPL7QO/whVaH9tSbgGawKQN1xAQcVj\n" +
            "NGamsBj5ysJMTVhP";


    public static byte[] getRSAPrivateKey() throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(RSA_PRIVATE_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        return privateKey.getEncoded();
    }

    public static byte[] getRSAPublicKey() throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(RSA_PUBLIC_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        return publicKey.getEncoded();
    }

    /**
     * 私钥加密
     * @param data
     * @param key
     * @return
     */
    public static String encryptByPrivateKey(String data,byte[] key) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    /**
     * 公钥加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data,byte[] key) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    /**
     * 公钥解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptByPublicKey(String data,byte[] key) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }

    /**
     * 私钥解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data,byte[] key) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return new String(cipher.doFinal(Base64.decodeBase64(data)));
    }
}
