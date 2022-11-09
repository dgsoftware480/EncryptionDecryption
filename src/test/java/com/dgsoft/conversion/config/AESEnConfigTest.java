package com.dgsoft.conversion.config;

import com.dgsoft.conversion.component.impl.TestObject;
import com.dgsoft.conversion.util.ObjectUtil;
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
public class AESEnConfigTest {
    private String strToEncrypt;
    private String key;
    private TestObject testObject;

    @InjectMocks
    private EncryptDecryptImpl encryptDecrypt;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.strToEncrypt = "This is the text to be encrypted";
        this.key = "MESSAGE_CONVERTER_SECRET_KEY";
        this.testObject = new TestObject(1234, "Test String", true);
    }

    @AfterEach
    public void tearDown() {
        this.strToEncrypt = null;
        this.key = null;
        this.testObject = null;
    }

    @Test
    public void givenStringEncryptAndEqualToDecryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt);
        Assertions.assertNotNull(encrypted);
        String decrypted = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decrypted);

        Assertions.assertEquals(decrypted, strToEncrypt);
    }

    @Test
    public void givenStringEncryptAndNotEqualToDecryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt);
        Assertions.assertNotNull(encrypted);
        String decrypted = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decrypted);

        Assertions.assertNotEquals(decrypted, "decrypted");
    }

    @Test
    public void givenStringAndKeyToEncryptEqualToDecryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt, key);
        Assertions.assertNotNull(encrypted);
        String decrypted = encryptDecrypt.aesDecryption(encrypted, key);
        Assertions.assertNotNull(decrypted);

        Assertions.assertEquals(decrypted, strToEncrypt);
    }

    @Test
    public void givenStringAndKeyToEncryptNotEqualToDecryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(strToEncrypt, key);
        Assertions.assertNotNull(encrypted);
        String decrypted = encryptDecrypt.aesDecryption(encrypted, key);
        Assertions.assertNotNull(decrypted);

        Assertions.assertNotEquals(decrypted, "decrypted");
    }

    @Test
    public void givenObjectEncryptAndEqualToDecryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(testObject);
        Assertions.assertNotNull(encrypted);
        String decrypted = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decrypted);
        Assertions.assertEquals(decrypted, ObjectUtil.asJasonString(testObject));
    }

    @Test
    public void givenObjectEncryptAndNotEqualToDecryptedValue() {
        String encrypted = AESEnConfig.encryptUsingKey(testObject);
        Assertions.assertNotNull(encrypted);
        String decrypted = encryptDecrypt.aesDecryption(encrypted);
        Assertions.assertNotNull(decrypted);

        Assertions.assertNotEquals(decrypted, "decrypted");
    }
}
