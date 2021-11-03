package com.util.zjxl;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class TransCode {
    private static final String PUBLICKEY = "CTFOTRV1";

    public TransCode() {
    }

    private static String decode(String message, String key) throws Exception {
        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(2, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte);
    }

    private static byte[] encode(String message, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(1, secretKey, iv);
        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    private static byte[] convertHexString(String ss) {
        byte[] digest = new byte[ss.length() / 2];

        for(int i = 0; i < digest.length; ++i) {
            String byteString = ss.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte)byteValue;
        }

        return digest;
    }

    public static String encode(String message) {
        if (message != null && message.trim().length() != 0) {
            try {
                String mw = toHexString(encode(message, "CTFOTRV1")).toUpperCase();
                return mw;
            } catch (Exception var2) {
                return null;
            }
        } else {
            System.err.println("message is  empty");
            return null;
        }
    }

    public static String decode(String ciphertext) throws Exception {
        try {
            String clearText = decode(ciphertext, "CTFOTRV1");
            return clearText;
        } catch (Exception var2) {
            System.err.println("ciphertext is  empty");
            return null;
        }
    }

    private static String toHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            String plainText = Integer.toHexString(255 & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }

            hexString.append(plainText);
        }

        return hexString.toString();
    }

    public static void getSecretKeys(String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException, InvalidKeyException {
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        String srt = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println(srt);
    }

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException {
        getSecretKeys(PUBLICKEY);
    }
}
