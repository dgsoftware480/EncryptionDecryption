package com.dgsoft.conversion.config;

import com.dgsoft.conversion.util.ConstantsUtil;
import com.dgsoft.conversion.util.ObjectUtil;
import lombok.NoArgsConstructor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

import static com.dgsoft.conversion.util.ObjectUtil.asJasonObject;

/*---RSAEnConfig is a class which provides RSA/EBC/PKCS1Padding encryption and decryption
    with private and public keys of 1024 key size---*/
@NoArgsConstructor
public class RSAEnConfig {

    /*--- encrypt method receives a generic object as its parameter and returns encrypted message---*/
    public static String encrypt(Object object) {
        try {
            //converts object into string before encrypting
            String message = ObjectUtil.asJasonString(object);
            byte[] messageToBytes = message.getBytes();

            RSAKeyHandler keyHandler = new RSAKeyHandler();
            Cipher cipher = null;

            cipher = Cipher.getInstance(ConstantsUtil.RSA_ALGO);

            cipher.init(Cipher.ENCRYPT_MODE, keyHandler.publicKey);

            byte[] encryptedBytes = new byte[0];

            encryptedBytes = cipher.doFinal(messageToBytes);

            //converts byte[] message into base64 encrypted message then returns
            return Base64Config.encryptBase64(encryptedBytes);

        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
                | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*--- decryptUsingKey method receives a string as its parameter and returns decrypted Object---*/
    public static Object decrypt(String encryptedMessage) {

        try {
            //converts base64 encrypted string into string before decrypting with RSA
            byte[] encryptedBytes = Base64Config.decryptBase64(encryptedMessage);
            Cipher cipher = null;

            cipher = Cipher.getInstance(ConstantsUtil.RSA_ALGO);

            RSAKeyHandler keyHandler = new RSAKeyHandler();
            cipher.init(Cipher.DECRYPT_MODE, keyHandler.privateKey);
            byte[] decryptedMessage = cipher.doFinal(encryptedBytes);

            //converts to object before returning
            return ObjectUtil.asJasonObject(new String(decryptedMessage));
        } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
                | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
}
