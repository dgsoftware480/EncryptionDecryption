package com.dgsoft.conversion.config;


import com.dgsoft.conversion.component.impl.TestObject;
import com.dgsoft.conversion.component.impl.EncryptDecryptImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AESDeConfigTest {

    private String strToEncrypt;
    private String strToDecrypt;
    private String encryptedObject;
    private String key;
    private TestObject testObject;

    @InjectMocks
    private EncryptDecryptImpl encryptDecrypt;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.strToEncrypt = "This is the text to be encrypted";
        this.strToDecrypt = "0ht7wY1OHGXUu95wuUFUgNGvj0TH/IrTKRrENG6uhrbjfXbnfw3NGXGRW7uh4EJuV7TrFWS8JgCkH7WM5Ofzwg==";
        this.key = "MESSAGE_CONVERTER_SECRET_KEY";
        this.testObject = new TestObject(1234, "Test String", true);
        this.encryptedObject = "ZGyXKoHQ22IZEFOtoMKmMeDNVl0D7PVhsnuO1qe3FYDtuPjklSfaDR4elrvq1y6KsqtgpU+gu7+YNekcd2z9iKAoWwWeeM+5dOrWpErPk9U=";
    }

    @AfterEach
    public void tearDown() {
        this.strToEncrypt = null;
        this.strToDecrypt = null;
        this.key = null;
        this.testObject = null;
    }

    @Test
    public void givenStringAndDecryptedEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt);
        Assertions.assertNotNull(encrypted);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decryptedPre);
        String decryptedNew = encryptDecrypt.aesDecryption(strToDecrypt);
        Assertions.assertNotNull(decryptedNew);

        Assertions.assertEquals(decryptedPre, decryptedNew);
    }

    @Test
    public void givenStringAndDecryptedNotEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt);
        Assertions.assertNotNull(encrypted);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decryptedPre);
        String decryptedNew = encryptDecrypt.aesDecryption(strToDecrypt);
        Assertions.assertNotNull(decryptedNew);

        Assertions.assertNotEquals(decryptedPre, decryptedNew + "decryptedNew");
    }

    @Test
    public void givenStringAndKeyDecryptedEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt, key);
        Assertions.assertNotNull(encrypted);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted, key);
        Assertions.assertNotNull(decryptedPre);
        String decryptedNew = encryptDecrypt.aesDecryption(strToDecrypt, key);
        Assertions.assertNotNull(decryptedNew);

        Assertions.assertEquals(decryptedPre, decryptedNew);
    }

    @Test
    public void givenStringAndKeyDecryptedNotEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt, key);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted, key);
        String decryptedNew = encryptDecrypt.aesDecryption(strToDecrypt, key);

        Assertions.assertNotNull(decryptedNew);
        Assertions.assertNotNull(decryptedPre);
        Assertions.assertNotNull(encrypted);
        Assertions.assertNotEquals(decryptedPre, "decryptedNew");
    }

    @Test
    public void givenObjectDecryptAndEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(testObject);
        Assertions.assertNotNull(encrypted);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decryptedPre);
        String decryptedNew = encryptDecrypt.aesDecryption(encryptedObject);
        Assertions.assertNotNull(decryptedNew);

        Assertions.assertEquals(decryptedPre, decryptedNew);
        Assertions.assertEquals(decryptedNew.length(), decryptedPre.length());
    }

    @Test
    public void givenObjectDecryptAndNotEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(testObject);
        Assertions.assertNotNull(encrypted);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decryptedPre);
        String decryptedNew = encryptDecrypt.aesDecryption(encryptedObject);
        Assertions.assertNotNull(decryptedNew);

        Assertions.assertNotEquals(decryptedPre, decryptedNew + "decrypted");
        Assertions.assertNotEquals(decryptedNew.length(), decryptedPre + "decrypted".length());
    }

    @Test
    public void givenObjectAndKeyDecryptAndEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(testObject);
        Assertions.assertNotNull(encrypted);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted, key);
        Assertions.assertNotNull(decryptedPre);
        String decryptedNew = encryptDecrypt.aesDecryption(encryptedObject, key);
        Assertions.assertNotNull(decryptedNew);

        Assertions.assertEquals(decryptedPre, decryptedNew);
        Assertions.assertEquals(decryptedNew.length(), decryptedPre.length());
    }

    @Test
    public void givenObjectAndKeyDecryptAndNotEqualToEncryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(testObject);
        Assertions.assertNotNull(encrypted);
        String decryptedPre = encryptDecrypt.aesDecryption(encrypted, key);
        Assertions.assertNotNull(decryptedPre);
        String decryptedNew = encryptDecrypt.aesDecryption(encryptedObject, key);
        Assertions.assertNotNull(decryptedNew);

        Assertions.assertNotEquals(decryptedPre, decryptedNew + "decrypted");
        Assertions.assertNotEquals(decryptedNew.length(), decryptedPre + "decrypted".length());
    }
}
