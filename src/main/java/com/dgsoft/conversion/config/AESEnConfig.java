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
import java.security.*;

/*---AESEnConfig is a class which provides AES/CBC/PKCS5Padding encryption and decryption  with a key
    that is encrypted with SHA-256 algorithm---*/
@NoArgsConstructor
public class AESEnConfig {
    private static final Logger log = LoggerFactory.getLogger(AESEnConfig.class);

    /*--- encryptUsingKey method receives a generic object as its parameter and returns encrypted message---*/
    public static String encryptUsingKey(Object object) {
        log.info("Entering:: MessageSecurity:: AESEnConfig:: encryptUsingKey method");
        try {
            //converts object into string before encrypting
            String strToEncrypt = ObjectUtil.asJasonString(object);
            int ivSize = ConstantsUtil.BYTE_SIZE;
            byte[] iv = new byte[ivSize];

            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            MessageDigest digest = null;

            digest = MessageDigest.getInstance(ConstantsUtil.HASH_ALGO);

            digest.update(ConstantsUtil.AES_SECRET_KEY.getBytes());

            byte[] keyBytes = new byte[ivSize];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance(ConstantsUtil.AES_ALGO);
            cipher.init(1, secretKeySpec, ivParameterSpec);

            byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes());
            byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
            System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
            System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

            String result = Base64Config.encryptBase64(encryptedIVAndText);
            log.info("Result:: MessageSecurity:: AESEnConfig:: encryptUsingKey method {}",result);
            //converts byte[] message into base64 encrypted message then returns
            return result;

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException |
                NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            log.error("ERROR:: MessageSecurity:: AESDeConfig:: encryptUsingKey method:: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptUsingKey(String strToEncrypt) {
        log.info("Entering:: MessageSecurity:: AESEnConfig:: encryptUsingKey method");
        try {
            int ivSize = ConstantsUtil.BYTE_SIZE;
            byte[] iv = new byte[ivSize];

            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            MessageDigest digest = null;

            digest = MessageDigest.getInstance(ConstantsUtil.HASH_ALGO);

            digest.update(ConstantsUtil.AES_SECRET_KEY.getBytes());

            byte[] keyBytes = new byte[ivSize];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance(ConstantsUtil.AES_ALGO);
            cipher.init(1, secretKeySpec, ivParameterSpec);

            byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes());
            byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
            System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
            System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

            String result = Base64Config.encryptBase64(encryptedIVAndText);
            log.info("Result:: MessageSecurity:: AESEnConfig:: encryptUsingKey method {}",result);
            //converts byte[] message into base64 encrypted message then returns
            return result;

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            log.error("ERROR:: MessageSecurity:: AESDeConfig:: encryptUsingKey method:: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptUsingKey(String strToEncrypt, String key) {
        log.info("Entering:: MessageSecurity:: AESEnConfig:: encryptUsingKey method");
        try {
            int ivSize = ConstantsUtil.BYTE_SIZE;
            byte[] iv = new byte[ivSize];

            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            MessageDigest digest = null;

            digest = MessageDigest.getInstance(ConstantsUtil.HASH_ALGO);

            digest.update(key.getBytes());

            byte[] keyBytes = new byte[ivSize];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance(ConstantsUtil.AES_ALGO);
            cipher.init(1, secretKeySpec, ivParameterSpec);

            byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes());
            byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
            System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
            System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

            String result = Base64Config.encryptBase64(encryptedIVAndText);
            log.info("Result:: MessageSecurity:: AESEnConfig:: encryptUsingKey method {}",result);
            //converts byte[] message into base64 encrypted message then returns
            return result;

        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            log.error("ERROR:: MessageSecurity:: AESDeConfig:: encryptUsingKey method:: {}", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
