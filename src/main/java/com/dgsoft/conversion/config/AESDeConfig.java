package com.dgsoft.conversion.config;

import com.dgsoft.conversion.util.ConstantsUtil;
import com.dgsoft.conversion.util.ObjectUtil;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.dgsoft.conversion.util.ObjectUtil.asJasonObject;

@NoArgsConstructor
public class AESDeConfig {
    private static final Logger log = LoggerFactory.getLogger(AESDeConfig.class);

    /*--- decryptUsingKey method receives a string as its parameter and returns decrypted Object---*/
    public static String decryptUsingKey(String strToDecrypt) {
        log.info("Entering:: MessageSecurity:: AESDeConfig:: decryptUsingKey method");
        try {
            //converts base64 encrypted string into string before decrypting with AES
            byte[] encrypted = Base64Config.decryptBase64(strToDecrypt);
            int ivSize = ConstantsUtil.BYTE_SIZE;

            byte[] iv = new byte[ivSize];
            System.arraycopy(encrypted, 0, iv, 0, iv.length);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            int encryptedSize = encrypted.length - ivSize;
            byte[] encryptedBytes = new byte[encryptedSize];
            System.arraycopy(encrypted, ivSize, encryptedBytes, 0, encryptedSize);
            byte[] keyBytes = new byte[ConstantsUtil.BYTE_SIZE];

            MessageDigest md = MessageDigest.getInstance(ConstantsUtil.HASH_ALGO);
            md.update(ConstantsUtil.AES_SECRET_KEY.getBytes());
            System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipherDecrypt = Cipher.getInstance(ConstantsUtil.AES_ALGO);
            cipherDecrypt.init(2, secretKeySpec, ivParameterSpec);
            byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

            log.info("Result:: MessageSecurity:: AESDeConfig:: decryptUsingKey method {}", new String(decrypted));
            //converts to object before returning
            return new String(decrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException |
                InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
            log.error("ERROR:: MessageSecurity:: AESDeConfig:: decryptUsingKey method:: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptUsingKey(String strToDecrypt, String key) {
        log.info("Entering:: MessageSecurity:: AESDeConfig:: decryptUsingKey method");
        try {
            //converts base64 encrypted string into string before decrypting with AES
            byte[] encrypted = Base64Config.decryptBase64(strToDecrypt);
            int ivSize = ConstantsUtil.BYTE_SIZE;

            byte[] iv = new byte[ivSize];
            System.arraycopy(encrypted, 0, iv, 0, iv.length);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            int encryptedSize = encrypted.length - ivSize;
            byte[] encryptedBytes = new byte[encryptedSize];
            System.arraycopy(encrypted, ivSize, encryptedBytes, 0, encryptedSize);
            byte[] keyBytes = new byte[ConstantsUtil.BYTE_SIZE];

            MessageDigest md = MessageDigest.getInstance(ConstantsUtil.HASH_ALGO);
            md.update(key.getBytes());
            System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipherDecrypt = Cipher.getInstance(ConstantsUtil.AES_ALGO);
            cipherDecrypt.init(2, secretKeySpec, ivParameterSpec);
            byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

            log.info("Result:: MessageSecurity:: AESDeConfig:: decryptUsingKey method {}", new String(decrypted));
            //converts to object before returning
            return new String(decrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException |
                InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
            log.error("ERROR:: MessageSecurity:: AESDeConfig:: decryptUsingKey method:: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Object decryptUsingKeyObj(String strToDecrypt) {
        log.info("Entering:: MessageSecurity:: AESDeConfig:: decryptUsingKeyObj method");
        try {
            //converts base64 encrypted string into string before decrypting with AES
            byte[] encrypted = Base64Config.decryptBase64(strToDecrypt);
            int ivSize = ConstantsUtil.BYTE_SIZE;

            byte[] iv = new byte[ivSize];
            System.arraycopy(encrypted, 0, iv, 0, iv.length);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            int encryptedSize = encrypted.length - ivSize;
            byte[] encryptedBytes = new byte[encryptedSize];
            System.arraycopy(encrypted, ivSize, encryptedBytes, 0, encryptedSize);
            byte[] keyBytes = new byte[ConstantsUtil.BYTE_SIZE];

            MessageDigest md = MessageDigest.getInstance(ConstantsUtil.HASH_ALGO);
            md.update(ConstantsUtil.AES_SECRET_KEY.getBytes());
            System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipherDecrypt = Cipher.getInstance(ConstantsUtil.AES_ALGO);
            cipherDecrypt.init(2, secretKeySpec, ivParameterSpec);
            byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

            Object obj = ObjectUtil.asJasonObject(new String(decrypted));
            log.info("Result:: MessageSecurity:: AESDeConfig:: decryptUsingKeyObj method {}", obj);
            //converts to object before returning
            return obj;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException |
                InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
            log.error("ERROR:: MessageSecurity:: AESDeConfig:: decryptUsingKeyObj method:: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static Object decryptUsingKeyObj(String strToDecrypt, String key) {
        log.info("Entering:: MessageSecurity:: AESDeConfig:: decryptUsingKeyObj method");
        try {
            //converts base64 encrypted string into string before decrypting with AES
            byte[] encrypted = Base64Config.decryptBase64(strToDecrypt);
            int ivSize = ConstantsUtil.BYTE_SIZE;

            byte[] iv = new byte[ivSize];
            System.arraycopy(encrypted, 0, iv, 0, iv.length);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            int encryptedSize = encrypted.length - ivSize;
            byte[] encryptedBytes = new byte[encryptedSize];
            System.arraycopy(encrypted, ivSize, encryptedBytes, 0, encryptedSize);
            byte[] keyBytes = new byte[ConstantsUtil.BYTE_SIZE];

            MessageDigest md = MessageDigest.getInstance(ConstantsUtil.HASH_ALGO);
            md.update(key.getBytes());
            System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipherDecrypt = Cipher.getInstance(ConstantsUtil.AES_ALGO);
            cipherDecrypt.init(2, secretKeySpec, ivParameterSpec);
            byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

            Object obj = ObjectUtil.asJasonObject(new String(decrypted));
            log.info("Result:: MessageSecurity:: AESDeConfig:: decryptUsingKeyObj method {}", obj);
            //converts to object before returning
            return obj;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | BadPaddingException |
                InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
            log.error("ERROR:: MessageSecurity:: AESDeConfig:: decryptUsingKeyObj method:: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
